/**
 * @file MainActivity.java
 * @brief Main class of the application.
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
import java.util.ArrayList;

/**
 * @class MainActivity
 * @brief Main class of the application.
 */
public class MainActivity
{
	/** @brief Instance of the inspector. */
	private static LayoutInspector layoutInspector;
	/** @brief Number of minimum occurences. */
	private static int nbOcc = 2;
	/** @brief Size of the combination. */
	private static int combinationSize = 2;
	/** @brief Start path / file. */
	private static String path;
	
	/**
	 * @brief Main method of the program.
	 * @param args Arguments from the command line.
	 */
	public static void main(String[] args)
	{
		// Default path is current directory
		path = System.getProperty("user.dir");
		
		if (readArgs(args))
		{
			// Get all xml files in the selected path
			ArrayList<String> fileList = FileHelper.getAllXmlPath(path);
			
			// If files was found, launch the inspector
			if (fileList.size() > 0)
			{
				layoutInspector = new LayoutInspector();
				layoutInspector.launch(fileList);
				showResult();
			}
		}
		else
		{
			System.out.println(" [-o MINIMUM_NB_OCCURENCES] [-s MINIMUM_SIZE_COMBINATION] [PATH]");
		}
	}
	
	/**
	 * @brief Read arguments from the command line.
	 * @param args Arguments from the command line.
	 */
	private static boolean readArgs(String[] args)
	{
		if (args.length > 0)
		{
			for (int i = 0; i < args.length; ++i)
			{
				if (args[i].equals("-o") && (i + 1) < args.length)
				{
					if (isInteger(args[i + 1]))
					{
						nbOcc = Integer.parseInt(args[i + 1]);
						++i;
					}
					else
						return false;
				}
				if (args[i].equals("-s") && (i + 1) < args.length)
				{
					if (isInteger(args[i + 1]))
					{
						combinationSize = Integer.parseInt(args[i + 1]);
						++i;
					}
					else
						return false;
				}
				if (args[i].equals("-h"))
					return false;
			}
			if (!isInteger(args[args.length - 1]) && args[args.length - 1].charAt(0) != '-')
			{
				File file = new File(args[args.length - 1]);
				if (!file.exists())
					return false;
				path = file.getAbsolutePath();
			}
		}
		return true;
	}
	
	/**
	 * @brief Test if string is an integer.
	 * @param nb String to test.
	 * @return True if string is a number.
	 */
	private static boolean isInteger(String nb)
	{
		try
		{
			Integer.parseInt(nb);
		} catch (NumberFormatException e)
		{
			return false;
		}
		return true;
	}
	/**
	 * @brief Show result of inspector.
	 */
	private static void showResult()
	{
		ArrayList<Tuple> tupleList = layoutInspector.getTuplesResult();
		for (int i = 0; i < tupleList.size(); ++i)
		{
			if (tupleList.get(i).count >= nbOcc && tupleList.get(i).attrList.size() >= combinationSize)
			{
				System.out.println("Occurence : "+tupleList.get(i).count);
				System.out.println("Group of attributes : ");
				ArrayList<XmlAttr> list = tupleList.get(i).attrList;
				for (int j = 0; j < list.size(); ++j)
					System.out.println("\t"+list.get(j).key+"=\""+list.get(j).value+"\"");
				System.out.println("Concerned files : ");
				ArrayList<String> files = tupleList.get(i).files;
				for (int j = 0; j < files.size(); ++j)
					System.out.println("\t"+files.get(j));
				System.out.println();
			}
		}
	}
}
