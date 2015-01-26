/**
 * @file
 * @par File Name:
 * Ex02.java
 * @author budougumi0617
 * @date Created on 2015/01/26
 */
package main.java.ch7.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note Expected processing to JavaScript
 */
public class Ex02 {

	public static void main(String[] args) {
		String contents = null;
		try {
			contents = new String(Files.readAllBytes(Paths
					.get("./src/main/resources/ch2/alice.txt")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stream<String> s = Arrays.stream(contents.split("[\\P{L}]+")).distinct()
				.filter(w -> w.length() >= 12);
		s = s.sorted();
		s.forEachOrdered(System.out::println);
	}
}
