/**
 * @file
 * @par File Name:
 * Ex06.java
 * @author budougumi0617
 * @date Created on 2015/03/02
 */
package main.java.ch9.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author budougumi0617
 * @note ファイルのすべての行を読み込み、逆順に書き出すプログラムを作成しなさい。
 *       Files.readAllLinesとFiles.writeを使用しなさい。
 */
public class Ex06 {
	public static Path createDummyFile() {
		Path out = null;
		List<String> lines = new ArrayList<String>();
		lines.add("First");
		lines.add("Second");
		lines.add("Third");
		lines.add("Last");
		try {
			out = Files.createTempFile(null, ".txt");
			Files.write(out, lines);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return out;
	}

	public static Path createReverseLinesFile(Path file) {
		Path path = null;
		try {
			List<String> lines = Files.readAllLines(file);
			Collections.reverse(lines);
			path = Files.createTempFile(null, ".txt");
			Files.write(path, lines);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static void main(String[] args) {
		try {
			Path path = createDummyFile();
			Files.readAllLines(createReverseLinesFile(path)).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
