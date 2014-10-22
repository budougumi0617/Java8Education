/**
 * @file
 * @par File Name:
 * Ex12.java
 * @author budougumi0617
 * @date Created on 2014/10/22
 */
package main.java.ch2.ex12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note 51ページの2.13「並列ストリーム」で説明したように、
 *       AtomicIntegerの配列を更新することで、
 *       並列なStream<String>内の短い単語を全て数えなさい。
 *       個々のカウントを安全に増やすためにアトミックである
 *       getAndIncrementメソッドを使用しなさい。
 */
public class Ex12 {
	static final int SHORT_LENGTH = 12;

	public static List<String> getWordsList() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("./src/main/resources/ch2/alice.txt")),
				StandardCharsets.UTF_8);
		return Arrays.asList(contents.split("[\\P{L}]+"));

	}

	public static AtomicInteger[] countShorWordsUsingParallel(int length,
			Stream<String> words) {
		AtomicInteger[] resultArray = new AtomicInteger[length];
		for (int i = 0; i < length; i++) {
			resultArray[i] = new AtomicInteger();
		}
		words.parallel().forEach(s -> {
			if (s.length() < length) {
				resultArray[s.length()].getAndIncrement();
			}
		});
		return resultArray;
	}

	public static void main(String[] args) {

		try {
			System.out.println("Count Result :"
					+ Arrays.toString(countShorWordsUsingParallel(SHORT_LENGTH,
							Ex12.getWordsList().stream())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
