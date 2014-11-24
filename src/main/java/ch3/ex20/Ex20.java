/**
 * @file
 * @par File Name:
 * Ex20.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package main.java.ch3.ex20;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author budougumi0617
 * @note staticメソッドである<T, U> List<U> map(List<T>
 *       Function<T,U>)を提供しなさい。
 */
public class Ex20 {
	public static <T, U> List<U> map(List<T> list, Function<T, U> func) {
		return list.stream().map(func).collect(Collectors.toList());
	}
}
