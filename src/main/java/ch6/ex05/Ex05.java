/**
 * @file
 * @par File Name:
 * Ex05.java
 * @author budougumi0617
 * @date Created on 2015/01/18
 */
package main.java.ch6.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author budougumi0617
 * @note 複数スレッドが複数のファイルから全ての単語を読み込むアプリケーションを書きなさい。
 *       各単語がどのファイルで使用されていたかを管理するために
 *       ConcurrentHashMap<String, Set<File>>
 *       を使用しなさい。 マップを更新するために、mergeメソッドを使用しなさい。
 */
public class Ex05 {

	public static List<String> getWordsList(File file) throws IOException {
		String contents = new String(Files.readAllBytes(file.toPath()),
				StandardCharsets.UTF_8);
		return Arrays.asList(contents.split("[\\P{L}]+"));
	}

	public static Map<String, Set<File>> newWordMap(File[] files) {
		Map<String, Set<File>> wordMap = new ConcurrentHashMap<String, Set<File>>();
		Arrays.stream(files).parallel().forEach(file -> {
			List<String> words;
			try {
				words = getWordsList(file);
				words.stream().forEach(word -> {
					Set<File> value = new HashSet<File>();
					value.add(file);
					wordMap.merge(word, value, (existingSet, newSet) -> {
						existingSet.addAll(newSet);
						return existingSet;
					});
				});
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		return wordMap;
	}

	public static void main(String[] args) {
		File[] files = { new File("./src/main/resources/ch2/alice.txt"),
				new File("./src/main/resources/ch2/war-and-peace.txt") };
		Map<String, Set<File>> result = newWordMap(files);
		result.forEach((word, valueSet) -> {
			System.out.println("-----\nword is :" + word);
			valueSet.forEach(file -> System.out.println("include file : "
					+ file.toString()));
		});
	}
}
