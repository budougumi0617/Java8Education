/**
 * @file
 * @par File Name:
 * Ex09.java
 * @author budougumi0617
 * @date Created on 2014/10/21
 */
package main.java.ch2.ex09;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

import main.java.util.StreamOperating;

/**
 * @author budougumi0617
 * @note Stream<ArrayList<T>>内の全ての要素を、
 *       １つのArrayList<T>へまとめなさい。
 *       具体的には、3つの形式のreduceを用いる方法を示しなさい。
 */
public class Ex09 {
	/**
	 * 
	 * @note T reduce(T identity,
	 *       BinaryOperator<T> accumulator)
	 * 
	 */
	public static <T> ArrayList<T> joinListStreamFirst(
			Stream<ArrayList<T>> listStream) {
		return listStream.reduce(new ArrayList<T>(), (x, y) -> {
			x.addAll(y);
			return x;
		});
	}

	/**
	 * 
	 * @note Optional<T> reduce(BinaryOperator<T>
	 *       accumulator)
	 */
	public static <T> ArrayList<T> joinListStreamSecond(
			Stream<ArrayList<T>> listStream) {
		Optional<ArrayList<T>> result = listStream.reduce((x, y) -> {
			x.addAll(y);
			return x;
		});
		return result.isPresent() ? result.get() : null;

	}

	/**
	 * 
	 * @note <U> U reduce(U identity,
	 *       BiFunction<U,? super T,U>
	 *       accumulator, BinaryOperator<U>
	 *       combiner)
	 */
	public static <T> ArrayList<T> joinListStreamThird(
			Stream<ArrayList<T>> listStream) {
		return listStream.reduce(new ArrayList<T>(), (x, y) -> {
			x.addAll(y);
			return x;
		}, (x1, x2) -> {
			x1.addAll(x2);
			return x1;
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\nFirst Pattern\n");
		Ex09.joinListStreamFirst(StreamOperating.createIntArraysListStream())
				.forEach(System.out::print);
		System.out.println("\nSecond Pattern\n");
		Ex09.joinListStreamSecond(StreamOperating.createIntArraysListStream())
				.forEach(System.out::print);
		System.out.println("\nThird Pattern\n");
		Ex09.joinListStreamThird(StreamOperating.createIntArraysListStream())
				.forEach(System.out::print);

	}

}
