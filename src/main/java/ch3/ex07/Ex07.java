/**
 * @file
 * @par File Name:
 * Ex07.java
 * @author budougumi0617
 * @date Created on 2014/11/03
 */
package main.java.ch3.ex07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author budougumi0617
 * @note Comparator<String>を生成するメソッドを書きなさい。
 *       普通の順序、逆順、大文字小文字を区別、 大文字小文字を区別しない、空白を含める、
 *       空白を除外する、あるいは、 これらの組み合わせとすることが
 *       できるComparator<String>にしなさい。
 *       メソッドは、ラムダ式を返すようにしなさい。
 */
public class Ex07 {
	public static Comparator<String> generateStringComparator(boolean isReverse,
			boolean isCaseInsensitive, boolean unIncludeSpace) {
		// TODO need refactoring
		Comparator<String> CaseInsensitive = (s1, s2) -> s1.compareToIgnoreCase(s2);
		Comparator<String> result = Comparator.comparing(s -> (String) s);
		if (unIncludeSpace) {
			result = (s1, s2) -> s1.replaceAll("[ 　]", "").compareTo(
					s2.replaceAll("[ 　]", ""));

		}
		if (isCaseInsensitive) {
			System.out.println("ignorecase true");
			result = CaseInsensitive.thenComparing(result);
		}
		if (isCaseInsensitive && unIncludeSpace) {
			result = (s1, s2) -> s1.replaceAll("[ 　]", "").compareToIgnoreCase(
					s2.replaceAll("[ 　]", ""));
		}
		if (isReverse) {
			System.out.println("reverse true");
			result = result.reversed();
		}
		return result;
	}

	public static void main(String[] args) {
		String[] words = { "00", "03", "0 1", "t3", "t0", "T2" };
		for (String w : words) {
			System.out.println(w);
		}
		Arrays.sort(words, Ex07.generateStringComparator(true, true, true));
		System.out.println("\n---Sorted---\n");
		for (String w : words) {
			System.out.println(w);
		}
		// words.stream().forEachOrdered(System.out::println);
	}
}
