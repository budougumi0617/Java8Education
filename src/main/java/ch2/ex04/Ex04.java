/**
 * @file
 * @par File Name:
 * Ex04.java
 * @author budougumi0617
 * @date Created on 2014/10/02
 */
package main.java.ch2.ex04;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note 配列int[] value = {1, 4, 9, 16}があるとします。
 *       Stream.of(values)は、何になるでしょうか。代わりに、
 *       intのストリームをどうやって取得できるのでしょうか。
 */
public class Ex04 {
	static final int[] values = { 1, 4, 9, 16 };

	public static Stream<int[]> getStreamOfIntArray() {
		return Stream.of(values);
	}

	public static IntStream getStreamOfIntByArrays() {
		return Arrays.stream(values);
	}

	public static IntStream getStreamOfIntByIntStream() {
		return IntStream.of(values);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Use Stream.of()");
		Ex04.getStreamOfIntArray().forEach(
				o -> System.out.println("stream element is " + o));
		System.out.println("Use Arrays.stream()");
		Ex04.getStreamOfIntByArrays().forEach(
				o -> System.out.println("stream element is " + o));
		System.out.println("Use IntStream.of()");
		Ex04.getStreamOfIntByIntStream().forEach(
				o -> System.out.println("stream element is " + o));
	}

}
