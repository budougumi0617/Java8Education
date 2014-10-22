/**
 * @file
 * @par File Name:
 * Ex13.java
 * @author budougumi0617
 * @date Created on 2014/10/22
 */
package main.java.ch2.ex13;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note 練習問題12に対して次の点を変更し、その問題を解きなさい。変更点として、
 *       短い文字列はフィルターで取り出し、 Collectors.groupingByと
 *       Collectors.countingと一緒に
 *       collectメソッドを使用しなさい。
 */
public class Ex13 {
	static final int SHORT_LENGTH = 12;

	public static List<String> getWordsList() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("./src/main/resources/ch2/alice.txt")),
				StandardCharsets.UTF_8);
		return Arrays.asList(contents.split("[\\P{L}]+"));

	}

	public static Long[] countShorWordsUsingParallel(int length,
			Stream<String> words) {
		Long[] resultArray = new Long[length];
		Map<Integer, Long> resultMap = words
				.filter(s -> s.length() < length)
				.parallel()
				.collect(
						Collectors.groupingBy(s -> s.length(),
								Collectors.counting()));
		for (Integer i : resultMap.keySet()) {
			resultArray[i] = resultMap.get(i);
		}
		return resultArray;
	}

	public static void main(String[] args) {

		try {
			System.out.println("Count Result :"
					+ Arrays.toString(countShorWordsUsingParallel(SHORT_LENGTH,
							Ex13.getWordsList().stream())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
