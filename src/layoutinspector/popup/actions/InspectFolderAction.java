/**
 * @file InspectFolderAction.java
 * @author Sylvain DANGIN
 * @brief Action on a folder.
 * @version 0.1
 * @date 6/17/2014
 * @copyright Copyright (c) 2014, Sylvain DANGIN\n
 * @par
All rights reserved.
Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
 * @par
1. Redistributions of source code must retain the above copyright notice, this
list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the followingdisclaimer in the documentation and/or
other materials provided with the distribution.
 * @par
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE 
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR 
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, 
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE 
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package layoutinspector.popup.actions;

import java.util.ArrayList;

import layoutinspector.views.LayoutInspectorView;
import libs.FileHelper;
import libs.LayoutInspector;

import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * @class InspectFolderAction
 * @brief Action on a folder.
 */
public class InspectFolderAction implements IObjectActionDelegate
{
	/** @brief Current folder. */
	private String currentFolder;
	
	/**
	 * @brief Constructor.
	 */
	public InspectFolderAction()
	{
		super();
		currentFolder = "";
	}

	/**
	 * @brief Sets the active part for the delegate.
	 * @param action Action proxy.
	 * @param targetPart New part target.
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart)
	{

	}

	/**
	 * @brief Called on action on a folder.
	 * @param action Action interface.
	 */
	public void run(IAction action)
	{
		ArrayList<String> fileList = FileHelper.getAllXmlPath(currentFolder);
		try
		{
			LayoutInspectorView view = (LayoutInspectorView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("layoutinspector.views.LayoutInspectorView");
			if (fileList.size() > 0)
			{
				LayoutInspector layoutInspector = new LayoutInspector();
				layoutInspector.launch(fileList);
				view.setData(layoutInspector.getTuplesResult());
			}
			else
				view.setData(null);
		}
		catch (PartInitException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @brief Called on selection changed.
	 * @param action Action interface.
	 * @param selection Selection interface.
	 */
	public void selectionChanged(IAction action, ISelection selection)
	{
		if (selection instanceof IStructuredSelection)
		{
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof IFolder)
			{
				IFolder folder = (IFolder) structuredSelection.getFirstElement();
				currentFolder = folder.getLocation().toString();
			}
		}
	}

}
