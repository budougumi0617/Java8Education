/**
 * @file
 * @par File Name:
 * OperateDirectory.java
 * @author budougumi0617
 * @date Created on 2014/09/01
 */
package ch1.ex01_02;

import java.io.File;
import java.io.FileFilter;

public class OperateDirectory {

	public static void main(String[] args) {
		File dir = new File("./src");
		File[] filesByOldMethod = OperateDirectory
				.getSubDirectoriesByOldMethod(dir);
		File[] filesByLambda = OperateDirectory.getSubDirectoriesByLambda(dir);
		File[] filesByMethodReference = OperateDirectory
				.getSubDirectoriesByMethodReference(dir);
		System.out.println(dir.toString() + " includes "
				+ filesByOldMethod.length + " dir(s):");
		for (File file : filesByOldMethod) {
			System.out.println("\t" + file.toString());
		}
		System.out.println("By Lambda");
		for (File file : filesByLambda) {
			System.out.println("\t" + file.toString());
		}
		System.out.println("By MethodReference");
		for (File file : filesByMethodReference) {
			System.out.println("\t" + file.toString());
		}
	}

	private static File[] getSubDirectoriesByOldMethod(File currentDir) {
		File[] dirs = currentDir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathName) {
				return pathName.isDirectory();
			}

		});
		File[] result = dirs.clone();
		for(File file : dirs){
			File[] files = OperateDirectory.getSubDirectoriesByOldMethod(file);
			result = OperateDirectory.updateResult(result, files);
		}
		return result;
	}

	private static File[] getSubDirectoriesByLambda(File currentDir) {
		File[] dirs = currentDir.listFiles(directoryName 
				-> directoryName.isDirectory()); // Lambda Expressions
		File[] result = dirs.clone();
		for(File file : dirs){
			File[] files = OperateDirectory.getSubDirectoriesByLambda(file);
			result = OperateDirectory.updateResult(result, files);
		}
		return result;
	}

	private static File[] getSubDirectoriesByMethodReference(File currentDir) {
		File[] dirs = currentDir.listFiles(File::isDirectory); // MethodReference,object::instanceMethod
		File[] result = dirs.clone();
		for(File file : dirs){
			File[] files = OperateDirectory.getSubDirectoriesByMethodReference(file);
			result = OperateDirectory.updateResult(result, files);
		}
		return result;
	}
	
	private static File[] updateResult(File[] result, File[] addFileList){
		File[] newResult = new File[result.length + addFileList.length];
		System.arraycopy(result, 0, newResult, 0, result.length);
		System.arraycopy(addFileList, 0, newResult, result.length, addFileList.length);
		return newResult;
	}
}
