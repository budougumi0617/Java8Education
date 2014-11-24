/**
 * @file
 * @par File Name:
 * Ex09.java
 * @author budougumi0617
 * @date Created on 2014/11/24
 */
package main.java.ch3.ex09;

import java.util.Comparator;
import java.util.function.Function;

/**
 * @author budougumi0617
 * @note README.md参照
 */
public class Ex09 {
	public static <T> Comparator<T> lexicographicComparator(String... fieldNames) {
		if (fieldNames == null) {
			return (t1, t2) -> 0;
		}
		Comparator<T> comp = Comparator.comparing(createKeyExtractor(fieldNames[0]));
		for (int i = 1; i < fieldNames.length; i++) {
			comp.thenComparing(createKeyExtractor(fieldNames[i]));
		}
		return comp;
	}

	@SuppressWarnings("unchecked")
	private static <T, U> Function<T, U> createKeyExtractor(String fieldName) {
		return t -> {
			try {
				return (U) t.getClass().getField(fieldName).get(t);
			} catch (IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
			return null;
		};
	}
}
