/**
 * @file
 * @par File Name:
 * Ex05.java
 * @author budougumi0617
 * @date Created on 2015/03/02
 */
package main.java.ch9.ex05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import main.java.ch9.ex06.Ex06;

/**
 * @author budougumi0617
 * @note ファイルから全ての文字を読み込み、逆順に書き出すプログラムを作成しなさい。
 *       Files.readAllBytesとFiles.writeを使用しなさい。
 */
public class Ex05 {

	public static Path createReverseContentFile(Path file) {
		Path path = null;
		try {
			byte[] bytes = Files.readAllBytes(file);
			String content = new String(bytes, StandardCharsets.UTF_8);
			StringBuilder sb = new StringBuilder(content);
			path = Files.createTempFile(null, ".txt");
			Files.write(path, sb.reverse().toString().getBytes(StandardCharsets.UTF_8));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static void main(String[] args) {
		try {
			Path path = Ex06.createDummyFile();
			Files.readAllLines(createReverseContentFile(path)).forEach(
					System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
