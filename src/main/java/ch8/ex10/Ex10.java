/**
 * @file
 * @par File Name:
 * Ex10.java
 * @author budougumi0617
 * @date Created on 2015/04/02
 */
package main.java.ch8.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.zip.ZipFile;

/**
 * @author budougumi0617
 * @note JDKに含まれるsrc.zipファイルを展開しなさい。
 *       Files.walkを使用して、予約語であるtransientと
 *       volatileを含むJavaのファイルを全て見つけなさい。
 */
public class Ex10 {
	public static void findFilesInJavaSrc(String zip) {
		try (ZipFile zipFile = new ZipFile(zip, Charset.forName("UTF-8"))) {
			zipFile.stream()
					.filter(entry -> !entry.isDirectory())
					.filter(entry -> {
						boolean hasVolatile = false;
						boolean hasTransient = false;
						try (BufferedReader br = new BufferedReader(
								new InputStreamReader(zipFile.getInputStream(entry)))) {

							for (String line = br.readLine(); line != null; line = br
									.readLine()) {
								if (line.indexOf("volatile") != -1) {
									hasVolatile = true;
								}
								if (line.indexOf("transient") != -1) {
									hasTransient = true;
								}
							}

						} catch (IOException e) {
							e.printStackTrace();
						}
						return hasVolatile && hasTransient;
					}).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		findFilesInJavaSrc("/Library/Java/JavaVirtualMachines/jdk1.8.0_05.jdk/Contents/Home/"
				+ "src.zip");

	}
}
