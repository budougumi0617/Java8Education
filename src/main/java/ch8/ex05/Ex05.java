/**
 * @file
 * @par File Name:
 * Ex05.java
 * @author budougumi0617
 * @date Created on 2015/03/31
 */
package main.java.ch8.ex05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Ex05 {

	private static final int LONG_LENGTH = 10;

	public static List<String> getWordsList() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("./src/main/resources/ch2/war-and-peace.txt")),
				StandardCharsets.UTF_8);
		return (List<String>) Arrays.asList(contents.split("[\\P{L}]+"));

	}

	public static long countLongWordsByStream(List<String> list) {
		return list.stream().filter(w -> w.length() > LONG_LENGTH).count();
	}

	public static long countLongWords(List<String> list) {
		AtomicLong count = new AtomicLong(0L);
		list.forEach(w -> {
			if (w.length() > LONG_LENGTH) {
				count.incrementAndGet();
			}
		});
		return count.get();
	}

	public static void main(String[] args) {

		try {
			long startTime = 0;
			long result = 0;
			long endTime = 0;
			long averageByStream = 0;
			long averageNoStream = 0;
			long maxTimes = 100;
			List<String> words = getWordsList();
			for (int i = 0; i < maxTimes; i++) {

				startTime = System.nanoTime();
				result = countLongWords(words);
				endTime = System.nanoTime();
				averageNoStream += (endTime - startTime);
				startTime = System.nanoTime();
				result = countLongWordsByStream(words);
				endTime = System.nanoTime();
				averageByStream += (endTime - startTime);
			}
			averageByStream /= (long) maxTimes;
			averageNoStream /= (long) maxTimes;
			System.out.println("Result " + result + "\nUse Stream time "
					+ averageByStream + "\nNot Stream time " + averageNoStream);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
