/**
 * @file LayoutInspector.java
 * @brief Class of the inspector.
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @class LayoutInspector
 * @brief Class of the inspector.
 * @author Sylvain DANGIN
 */
public class LayoutInspector
{
	/** @brief List of ignored tags. */
	private final String TAG_IGNORE[] = {"android:id", "android:contentDescription"}; 
	/** @brief Current readed file. */
	private String currentFile;
	/** @brief List of all unique xml attributes used. */
	private ArrayList<XmlAttr> baseItemList;
	/** @brief List of all tuples found. */
	private ArrayList<Tuple> tupleList;
	
	/**
	 * @brief Constructor of the class. 
	 */
	public LayoutInspector()
	{
		baseItemList = new ArrayList<XmlAttr>();
		tupleList = new ArrayList<Tuple>();
	}
	
	/**
	 * @brief Laucnh the inspector.
	 * @details Find all possible tuples and count them.
	 * @param fileList List of xml files.
	 */
	public void launch(ArrayList<String> fileList)
	{
		for (String filePath : fileList)
			parseFile(filePath);
		
		// Sort result
		Collections.sort(tupleList, new Comparator<Tuple>() {
			public int compare(Tuple o1, Tuple o2) {
				if (o1.attrList.size() > o2.attrList.size())
					return -1;
				else if(o1.attrList.size() < o2.attrList.size())
					return 1;
				return o2.count - o1.count; 
				
			}
		});
	}
	
	/**
	 * @brief Read the xml data.
	 * @param filePath Path of the xml file.
	 */
	private void parseFile(String filePath)
	{
		currentFile = filePath;
		File file = new File(filePath);
		if (file.exists())
		{
			try
			{
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
				Document document = documentBuilder.parse(file);
				
				Node root = document.getFirstChild();
				if (root != null)
					parseNode(root);
				
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @brief Explore the node and all children.
	 * @param node Start node.
	 */
	private void parseNode(Node node)
	{
		NodeList children = node.getChildNodes();
		for (int i = 0; i < children.getLength(); ++i)
		{
			ArrayList<XmlAttr> attrList = readAttributes(children.item(i));
			parseAttributes(attrList);
			parseNode(children.item(i));
		}
	}
	
	/**
	 * @brief Read xml attributes of the node.
	 * @param node Node to read.
	 * @return Attributes combination of the node.
	 */
	private ArrayList<XmlAttr> readAttributes(Node node)
	{
		ArrayList<XmlAttr> ret = new ArrayList<XmlAttr>();
		
		if (!node.getNodeName().equals("#text"))
		{
			NamedNodeMap attributes = node.getAttributes();
			for (int i = 0; i < attributes.getLength(); ++i)
			{
				Node attr = attributes.item(i);
				ret.add(new XmlAttr(attr.getNodeName(), attr.getNodeValue()));
			}
		}
		return ret;
	}
	
	/**
	 * @brief Parse attributes and create tuples.
	 * @param attrList List of node attributes.
	 */
	private void parseAttributes(ArrayList<XmlAttr> attrList)
	{
		// Sort attributes by key name
		Collections.sort(attrList, new Comparator<XmlAttr>() {
			public int compare(XmlAttr o1, XmlAttr o2) {
				return o1.key.compareTo(o2.key);
			}
		});
		
		boolean added;
		boolean ignore;
		// Read and create uniques combinations
		for (int i = 0; i < attrList.size(); ++i)
		{
			ignore = false;
			XmlAttr attr = attrList.get(i);
			for (int j = 0; j < TAG_IGNORE.length; ++j)
				if (attr.key.equals(TAG_IGNORE[j]))
					ignore = true;
			// Don't parse ignored tags.
			if (!ignore)
			{
				added = false;
				for (int j = 0; j < baseItemList.size(); ++j)
				{
					// Find if combination exist
					if (attr.equals(baseItemList.get(j).key, baseItemList.get(j).value))
					{
						++baseItemList.get(j).count;
						baseItemList.get(j).addFiles(currentFile);
						attr.id = baseItemList.get(j).id;
						added = true;
					}
				}
				// If not found, add this combination
				if (!added)
				{
					attr.addFiles(currentFile);
					baseItemList.add(attr);
				}
			}
		}
		
		// Creates all tuples (n > 1)
		for (int i = 1; i < attrList.size(); ++i)
			createTuple(attrList, new ArrayList<XmlAttr>(), 0, i + 1);
	}
	
	/**
	 * @brief Create tuples
	 * @param tupleData Base data.
	 * @param base Tuple construction.
	 * @param iteration Current iteration.
	 * @param size Size of the tuple wanted.
	 */
	public void createTuple(ArrayList<XmlAttr> tupleData, ArrayList<XmlAttr> base, int iteration, int size)
	{
		// Test if tuple size is reached.
		if (base.size() == size)
		{
			// Create unique tag
			String tag = "";
			for (int i = 0; i < size; ++i)
				tag += base.get(i).id+";";
			Tuple tuple = new Tuple();
			tuple.tag = tag;
			tuple.attrList.addAll(base);
			if (tupleList.size() == 0)
				tupleList.add(tuple);
			else
			{
				// Add tuple or increment count
				boolean added = false;
				for (int i = 0; i < tupleList.size(); ++i)
				{
					if (tupleList.get(i).tag.equals(tag))
					{
						added = true;
						++tupleList.get(i).count;
						tupleList.get(i).addFiles(currentFile);
					}
				}
				if (!added)
				{
					tuple.addFiles(currentFile);
					tupleList.add(tuple);
				}
					
			}
		}
		else
		{
			// If size not reach, go deeper
			for (int i = iteration; i < tupleData.size(); ++i)
			{
				base.add(tupleData.get(i));
				createTuple(tupleData, base, i + 1, size);
				base.remove(base.size() - 1);
			}
		}
	}
	
	/**
	 * @brief Get list of all tuples.
	 * @return Result of the inspector.
	 */
	public ArrayList<Tuple> getTuplesResult()
	{
		return tupleList;
	}
}
