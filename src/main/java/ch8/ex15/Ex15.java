/**
 * @file
 * @par File Name:
 * Ex15.java
 * @author budougumi0617
 * @date Created on 2015/04/06
 */
package main.java.ch8.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex15 {

	public static Stream<String> grepFile(String regex, String fileName) {
		Stream<String> result = Stream.empty();
		try {
			result = Files.lines(Paths.get(fileName)).filter(
					Pattern.compile(regex).asPredicate());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		Ex15.grepFile("^test", "./src/main/resources/ch8/wordsFile.txt").forEach(
				System.out::println);
	}
}
