/**
 * @file
 * @par File Name:
 * Collection2.java
 * @author budougumi0617
 * @date Created on 2014/10/18
 */
package main.java.ch1.ex09;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author budougumi0617
 * @param <T>
 * @note CollectionのサブインターフェースであるCollection2を作成して、
 *       デフォルトメソッドとして、 void forEachIf(Consumer<T>
 *       action, Predicate<T> filter)を追加しなさい。
 *       そのメソッドは、filterがtrueを返してきた個々の要素に対して、
 *       actionを適用します。どのような場面で、そのメソッドを活用できるでしょうか。
 */
public interface Collection2<T> extends Collection<T> {
	default void forEachIf(Consumer<T> action, Predicate<T> filter) {
		Objects.requireNonNull(filter);
		for (T t : this) {
			if (filter.test(t)) {
				action.accept(t);
			}
		}
	}
}
