/**
 * @file
 * @par File Name:
 * SearchLongWordsOnlyFive.java
 * @author budougumi0617
 * @date Created on 2014/10/02
 */
package main.java.ch2.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author budougumi0617
 * @note 
 *       ある文字数以上の長い単語のうち最初の5個だけが求める処理において、5番目の長い単語がいったん
 *       みつかったら、filterメソッドが呼び出されないことを検証しなさい。単純に、
 *       各メソッドの呼び出しで、ログを出せば良いです。
 */
public class Ex02 {

	List<String> words;
	private static final int LONG_LENGTH = 12;
	public static final int LIMIT_COUNT = 5;
	private int count = 0;

	public List<String> getWordsList() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("./src/main/resources/ch2/alice.txt")),
				StandardCharsets.UTF_8);
		return (List<String>) Arrays.asList(contents.split("[\\P{L}]+"));

	}

	public int searchLongWord(List<String> words) {
		count = 0;
		words.stream().peek(e -> System.out.println("peek " + e))
				.filter(w -> w.length() > LONG_LENGTH)
				.peek(e -> {
					count++;
					System.out.println("Fetching filter " + e);
				}).limit(LIMIT_COUNT).forEach(System.out::println);
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ex02 ex02 = new Ex02();
		try {
			ex02.words = ex02.getWordsList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Count of calling filter() = "
				+ ex02.searchLongWord(ex02.words));
	}

}
