/**
 * @file
 * @par File Name:
 * ShowSortedDirectoryInformation.java
 * @author budougumi0617
 * @date Created on 2014/09/16
 */
package main.java.ch1.ex04;

import java.io.File;
import java.util.Arrays;

/**
 * @author budougumi0617
 * @note Fileオブジェクトの配列が与えられたとします。その配列をソートして、
 * ファイルの前にディレクトリが来るようにし、ファイルとディレクトリのそれぞれのグループでは
 * パス名でソートされるようにしなさい。Comparatorでなく、ラムダ式を使用しなさい。
 */
public class ShowSortedDirectoryInformation {

	public static void main(String[] args) {
		File dir = new File("./");
		File[] filesByLambda = ShowSortedDirectoryInformation
				.createFilesList(dir);
		//List<String> result = getExtensionList(dir, "class");
		System.out.println("Before sort");
		for (File file : filesByLambda) {
			System.out.println("\t" + file.toString());
		}
		sortDirectoryInfomation(filesByLambda);
		System.out.println("After sort");
		for (File file : filesByLambda) {
			System.out.println("\t" + file.toString());
		}
		
	}

	private static void sortDirectoryInfomation(File[] fileArray){
		Arrays.sort(fileArray, (firstFile, secondFile) -> {
			if(firstFile.isDirectory() && secondFile.isFile()){
				return -1;
			}else if (firstFile.isFile() && secondFile.isDirectory()){
				return 1;
			}else{
				return firstFile.compareTo(secondFile);
			}
		});
	}

	private static File[] createFilesList(File currentDir) {
		File[] dirs = currentDir.listFiles();
		if(dirs == null)
			return new File[0];
		File[] result = dirs.clone();
		for (File file : dirs) {
			File[] files = ShowSortedDirectoryInformation
					.createFilesList(file);
			result = ShowSortedDirectoryInformation.updateResult(result, files);
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
