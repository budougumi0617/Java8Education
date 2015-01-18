/**
 * @file
 * @par File Name:
 * Ex06.java
 * @author budougumi0617
 * @date Created on 2015/01/18
 */
package main.java.ch6.ex06;

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
 * @note マップを更新するメソッドとして、
 *       mergeの代わりにcomuputeIfAbsentを使用して、
 *       練習問題5と同じアプリケーションを作成しなさい。 この方法の利点は何ですか。
 */
public class Ex06 {
	public static List<String> getWordsList(File file) throws IOException {
		String contents = new String(Files.readAllBytes(file.toPath()),
				StandardCharsets.UTF_8);
		return Arrays.asList(contents.split("[\\P{L}]+"));
	}

	public static Map<String, Set<File>> newWordMap(File[] files) {
		Map<String, Set<File>> wordMap = new ConcurrentHashMap<String, Set<File>>();
		Arrays.stream(files)
				.parallel()
				.forEach(
						file -> {
							List<String> words;
							try {
								words = getWordsList(file);
								words.stream().forEach(
										word -> wordMap.computeIfAbsent(word,
												key -> new HashSet<File>()).add(file));
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
