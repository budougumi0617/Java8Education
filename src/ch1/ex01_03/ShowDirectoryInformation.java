/**
 * @file
 * @par File Name:
 * OperateDirectory.java
 * @author budougumi0617
 * @date Created on 2014/09/01
 */
package ch1.ex01_03;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;


public class ShowDirectoryInformation {

	public static void main(String[] args) {
		File dir = new File("./");
		List<String> result = getExtensionList(dir, "class");

		System.out.println("Show result");
		for (String file : result) {
			System.out.println("\t" + file.toString());
		}
	}

	private static List<String> getExtensionList(File currentDir, String exType) {
		File[] dirs = ShowDirectoryInformation
				.getSubDirectoriesByLambda(currentDir);
		List<String> result = new ArrayList<String>();
		for (File dir : dirs) {
			String[] includeFile = dir.list((file, name) 
					-> {return name.endsWith(exType);}); //Captured "exType" from enclosing scope. 
			for (String file : includeFile) {
				result.add(file);
			}
		}
		return result;
	}

	private static File[] getSubDirectoriesByLambda(File currentDir) {
		// Lambda Expression
		File[] dirs = currentDir.listFiles(directoryName
				-> directoryName.isDirectory());
		File[] result = dirs.clone();
		for (File file : dirs) {
			File[] files = ShowDirectoryInformation
					.getSubDirectoriesByLambda(file);
			result = ShowDirectoryInformation.updateResult(result, files);
		}
		return result;
	}

	private static File[] updateResult(File[] result, File[] addFileList) {
		File[] newResult = new File[result.length + addFileList.length];
		System.arraycopy(result, 0, newResult, 0, result.length);
		System.arraycopy(addFileList, 0, newResult, result.length,
				addFileList.length);
		return newResult;
	}

}
