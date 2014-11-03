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
	static Comparator<String> generateStringComparator() {
		// TODO no implement yet.
		return (s1, s2) -> s1.compareTo(s2);
	}

	public static void main(String[] args) {
		String[] words = { "test0", "test 1", "test1", "Test2", "test3", "Test3" };
		for (String w : words) {
			System.out.println(w);
		}
		Arrays.sort(words, Ex07.generateStringComparator());
		System.out.println("\n---Sorted---\n");
		for (String w : words) {
			System.out.println(w);
		}
		// words.stream().forEachOrdered(System.out::println);
	}
}
