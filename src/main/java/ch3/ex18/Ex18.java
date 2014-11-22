/**
 * @file
 * @par File Name:
 * Ex18.java
 * @author budougumi0617
 * @date Created on 2014/11/22
 */
package main.java.ch3.ex18;

import java.util.function.Function;

/**
 * @author budougumi0617
 * @note 71ページの3.8節「例外の取り扱い」
 *       のuncheckedメソッドを次の内容に従って実装しなさい。
 *       具体的には、チェックされる例外をスローするラムダ式から
 *       Function<T,U>を生成するようにしなさい。
 *       任意の例外をスローする抽象メソッドを持つ関数型インターフェースを見つけるか、
 *       作成する必要があることに注意しなさい。
 */
public class Ex18 {
	@FunctionalInterface
	public interface FunctionEx<T, R> {
		public R apply(T t) throws RuntimeException;
	}

	public static <T, U> Function<T, U> unchecked(FunctionEx<T, U> func) {
		return (t) -> {
			U result = null;
			try {
				result = func.apply(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			return result;
		};
	}
}