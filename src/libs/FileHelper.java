/**
 * @file FileHelper.java
 * @author Sylvain DANGIN
 * @brief Class for all files access.
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

import java.io.File;
import java.util.ArrayList;

/**
 * @class FileHelper
 * @brief Class for all files access.
 */
public class FileHelper
{
	/**
	 * @brief Get all xml files in a folder and subfolders.
	 * @param rootFolder Root folder.
	 * @return List of xml path files.
	 */
	public static ArrayList<String> getAllXmlPath(String rootFolder)
	{
		ArrayList<String> result = new ArrayList<String>();
		File root = new File(rootFolder);
		if (root.exists())
		{
			if (isTargetFile(root, "xml"))
				result.add(root.getAbsolutePath());
			else 
				result = findFiles(root, "xml");
		}
		return result;
	}
	
	/**
	 * @brief Find files in a folder and subfolders.
	 * @param currentPath Current folder path.
	 * @param fileExtension Extension of wanted files. 
	 * @return List of xml files path.
	 */
	private static ArrayList<String> findFiles(File currentPath, String fileExtension)
	{
		ArrayList<String> result = new ArrayList<String>();
		if (currentPath.isDirectory())
		{
			File[] listFiles = currentPath.listFiles();
			for (int i = 0; i < listFiles.length; ++i)
			{
				if (isTargetFile(listFiles[i], fileExtension))
					result.add(listFiles[i].getAbsolutePath());
				else
					result.addAll(findFiles(listFiles[i], fileExtension));
			}
		}
		return result;
	}
	
	/**
	 * @brief Test the file extension.
	 * @param targetFile Target file.
	 * @param fileExtension Desired extension.
	 * @return True if the extension is good.
	 */
	private static boolean isTargetFile(File targetFile, String fileExtension)
	{
		if (targetFile.isFile())
		{
			if (targetFile.getName().endsWith("."+fileExtension))
				return true;
		}
		return false;
	}
}
