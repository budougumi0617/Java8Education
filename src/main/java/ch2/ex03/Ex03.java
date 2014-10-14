/**
 * @file
 * @par File Name:
 * SearchLongWordsOnlyFive.java
 * @author budougumi0617
 * @date Created on 2014/10/02
 */
package main.java.ch2.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note streamではなく、
 *       parallelStreamで長い単語を数えた場合の速度の違いを測りなさい。
 *       呼び出しの前後でSystem.nanoTimeを呼び出して、差を表示しなさい。
 *       高速なコンピュータを持っているのであれば、もっと大きなドキュメントで試しなさい。
 */
public class Ex03 {

	List<String> words;
	private static final int LONG_LENGTH = 12;
	public static final int LIMIT_COUNT = 5;
	private int count = 0;

	public List<String> getWordsList() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("./src/main/resources/ch2/war-and-peace.txt")),
				StandardCharsets.UTF_8);
		return (List<String>) Arrays.asList(contents.split("[\\P{L}]+"));

	}

	public long executeCountLongWords(Stream<String> stream) {
		return stream.filter(w -> w.length() > LONG_LENGTH).count();
	}

	public long countLongWordBySingle(List<String> words) {
		long start = System.nanoTime();
		long result = executeCountLongWords(words.stream());
		System.out.println("compute time is " + (System.nanoTime() - start) + " nano sec by single stream");
		return result;
	}

	public long countLongWordByParallel(List<String> words) {
		long start = System.nanoTime();
		long result = executeCountLongWords(words.stream().parallel());
		System.out.println("compute time is " + (System.nanoTime() - start) + " nano sec by parallel stream");
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ex03 ex03 = new Ex03();
		try {
			ex03.words = ex03.getWordsList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Count Result = "
				+ ex03.countLongWordBySingle(ex03.words));
		System.out.println("Count Result = "
				+ ex03.countLongWordByParallel(ex03.words));
	}

}
