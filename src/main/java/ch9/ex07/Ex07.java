/**
 * @file
 * @par File Name:
 * Ex07.java
 * @author budougumi0617
 * @date Created on 2015/03/01
 */
package main.java.ch9.ex07;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @author budougumi0617
 * @note ウェブページの内容を読み込んでファイルに保存するプログラムを作成しなさい。
 *       URL.openStreamとFiles.copyを使用しなさい。
 */
public class Ex07 {
	public static Path saveWebPage(URL url) {
		Path out = null;
		try {
			out = Files.createTempFile(null, ".txt");
			System.out.println("file = " + out.toString());
			try (InputStream page = url.openStream()) {
				Files.copy(page, out, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return out;
	}

	public static void main(String[] args) {
		Path result = null;
		try {
			result = saveWebPage(new URL("http://alc.co.jp"));
			Files.readAllLines(result).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
