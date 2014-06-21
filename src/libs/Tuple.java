/**
 * @file Tuple.java
 * @brief Class for tuples.
 * @author Sylvain DANGIN.
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
package libs;

import java.util.ArrayList;

/**
 * @class Tuple
 * @brief Class for tuples.
 */
public class Tuple
{
	/** @brief Number of occurences of this tuple. */
	public int count;
	/** @brief Unique tag of the tuple. */
	public String tag;
	/** @brief List of xml attributes for the tuple. */
	public ArrayList<XmlAttr> attrList;
	/** @brief List of files containing the key/value combination. */
	public ArrayList<String> files;
	
	/**
	 * @brief Constructor of the class.
	 */
	public Tuple()
	{
		count = 1;
		attrList = new ArrayList<XmlAttr>();
		files = new ArrayList<String>();
	}

	/** 
	 * @brief Add a file containing this combination.
	 */
	public void addFiles(String file)
	{
		if (!files.contains(file))
			files.add(file);
	}
}
