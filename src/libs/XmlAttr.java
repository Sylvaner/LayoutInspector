/**
 * @file XmlAttr.java
 * @brief Class for xml attributes.
 * @author Sylvain DANGIN
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
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @class XmlAttr
 * @brief Class for xml attributes.
 */
public class XmlAttr
{
	/** @brief Used to generate a unique id. */
	private static AtomicInteger idGenerator = new AtomicInteger();
	/** @brief Id of the key/value combination. */
	public int id;
	/** @brief Key of the attribute. */
	public String key;
	/** @brief Value of the attribute. */
	public String value;
	/** @brief Number of occurences. */
	public int count = 0;
	/** @brief List of files containing the key/value combination. */
	public ArrayList<String> files;
	
	/**
	 * @brief Empty constructor.
	 */
	public XmlAttr()
	{
		this("", "");
	}
	
	/**
	 * @brief Constructor of the class.
	 * @param key Key of the attribute.
	 * @param value Value of the attribute.
	 */
	public XmlAttr(String key, String value)
	{
		this.key = key;
		this.value = value;
		id = idGenerator.getAndIncrement();
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
	
	/**
	 * @brief Test with combination.
	 * @param testKey Key to test.
	 * @param testValue Value to test.
	 */
	public boolean equals(String testKey, String testValue)
	{
		return key.equals(testKey) && value.equals(testValue);
	}
}
