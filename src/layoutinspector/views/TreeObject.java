/**
 * @file TreeObject.java
 * @author Sylvain DANGIN
 * @brief Class used for the tree view.
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
package layoutinspector.views;

import org.eclipse.core.runtime.IAdaptable;

/**
 * @class TreeObject
 * @author Sylvain DANGIN
 * @brief Class used for the tree view.
 * @details Generated by Eclipse Wizard.
 */
class TreeObject implements IAdaptable
{
	/** @brief Numeric data used for sort. */
	private int data;
	/** @brief Showed name of the node. */
	private String name;
	/** @brief Parent of the node. */
	private TreeParent parent;
	
	/**
	 * @brief Constructor
	 * @param name Name of the node.
	 * @param data Data of the node.
	 */
	public TreeObject(String name, int data)
	{
		this.name = name;
		this.data = data;
	}
	
	/**
	 * @brief Data setter.
	 * @param data Text.
	 */
	public void setData(int data)
	{
		this.data = data;
	}
	
	/**
	 * @brief Data getter.
	 * @return Data of the node.
	 */
	public int getData()
	{
		return data;
	}
	
	/**
	 * @brief Name getter.
	 * @return Name of the node.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @brief Set the parent of the node.
	 * @param parent Parent of the node.
	 */
	public void setParent(TreeParent parent)
	{
		this.parent = parent;
	}
	
	/**
	 * @brief Parent getter.
	 * @return Parent of the node.
	 */
	public TreeParent getParent()
	{
		return parent;
	}
	
	/**
	 * @brief Get text from object.
	 * @return Text information of the node.
	 */
	public String toString()
	{
		return getName();
	}
	
	/**
	 * @brief Get adapter of the object.
	 * @param key ???
	 */
	public Object getAdapter(Class key)
	{
		return null;
	}
}