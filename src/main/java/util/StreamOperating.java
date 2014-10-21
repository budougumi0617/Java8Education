/**
 * @file
 * @par File Name:
 * StreamOperating.java
 * @author budougumi0617
 * @date Created on 2014/10/22
 */
package main.java.util;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note ストリーム系のutilメソッド
 */
public class StreamOperating {
	/**
	 * 
	 * @return ArrayList<Integer>を３つ含んだストリームを生成する。
	 *         それぞれのストリームの要素は0..9
	 */
	public static Stream<ArrayList<Integer>> createIntArraysListStream() {
		ArrayList<Integer> firstArray = new ArrayList<Integer>();
		// TODO Stream()で生成したい
		for (int i = 0; i < 10; i++) {
			firstArray.add(i);
		}
		@SuppressWarnings("unchecked")
		ArrayList<Integer> secondArray = (ArrayList<Integer>) firstArray
				.clone();
		@SuppressWarnings("unchecked")
		ArrayList<Integer> thirdArray = (ArrayList<Integer>) firstArray.clone();

		return Stream.of(firstArray, secondArray, thirdArray);

	}
}
