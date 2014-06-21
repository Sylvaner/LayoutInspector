/**
 * @file TreeParent.java
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

import java.util.ArrayList;

/**
 * @class TreeParent
 * @author Sylvain DANGIN
 * @brief Class used for the tree view.
 * @details Generated by Eclipse Wizard.
 */
class TreeParent extends TreeObject
{
	/** @brief List of all children. */
	private ArrayList<TreeObject> children;
	
	/**
	 * @brief Constructor.
	 * @param name Name of the node.
	 * @param data Data of the node.
	 */
	public TreeParent(String name, int data)
	{
		super(name, data);
		children = new ArrayList<TreeObject>();
	}
	
	/**
	 * @brief Add a child to the node
	 * @param child Child to add.
	 */
	public void addChild(TreeObject child)
	{
		children.add(child);
		child.setParent(this);
	}
	
	/**
	 * @brief Remove a child from the node.
	 * @param child Child to remove.
	 */
	public void removeChild(TreeObject child)
	{
		children.remove(child);
		child.setParent(null);
	}
	
	/**
	 * @brief Get array of children.
	 * @return Array of children.
	 */
	public TreeObject [] getChildren()
	{
		return (TreeObject [])children.toArray(new TreeObject[children.size()]);
	}
	
	/**
	 * @brief Test if node have children.
	 * @return True if node have children.
	 */
	public boolean hasChildren()
	{
		return children.size()>0;
	}
}
