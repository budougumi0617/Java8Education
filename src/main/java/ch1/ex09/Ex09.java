/**
 * @file
 * @par File Name:
 * Ex09.java
 * @author budougumi0617
 * @date Created on 2014/10/18
 */
package main.java.ch1.ex09;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author budougumi0617
 * @note CollectionのサブインターフェースであるCollection2を作成して、
 *       デフォルトメソッドとして、 void forEachIf(Consumer<T>
 *       action, Predicate<T> filter)
 *       を追加しなさい。そのメソッドは、filterがtrueを返してきた
 *       個々の要素に対して、actionを適用します。
 *       どのような場面で、そのメソッドを活用できるでしょうか。
 * 
 *       --- Answer:
 *       Collection.stream().filter().forEach()を
 *       使いたいときに活用できる。 ex09.stream().filter((s) ->
 *       { return s.length() > 5; }).forEach(s ->
 *       { System.out.println(s); });
 */
public class Ex09 extends ArrayList<String> implements Collection2<String> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ex09 ex09 = new Ex09();
		String contents = null;
		try {
			contents = new String(Files.readAllBytes(Paths
					.get("./src/main/resources/ch2/alice.txt")),
					StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ex09.addAll(Arrays.asList(contents.split("[\\P{L}]+")));
		ex09.forEachIf(s -> {
			System.out.println(s);
		}, s -> {
			return s.length() > 5;
		});
		/*
		 * ex09.stream().filter((s) -> { return
		 * s.length() > 5; }).forEach(s -> {
		 * System.out.println(s); });
		 */
	}
}
