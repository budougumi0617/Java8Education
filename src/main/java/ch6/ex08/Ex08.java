/**
 * @file
 * @par File Name:
 * Ex08.java
 * @author budougumi0617
 * @date Created on 2015/01/25
 */
package main.java.ch6.ex08;

import java.util.Arrays;
import java.util.stream.DoubleStream;

/**
 * @author budougumi0617
 * @note みなさんのコンピュータでは、Arrays.parallelSortは、
 *       配列がどのくらいの大きさであればArrays.sort()より速くなりますか。
 */
public class Ex08 {
	private static long resultTimebyParallel;
	private static long resultTimebySingle;

	public static long getSortedTimeByParallel(double[] array) {
		System.out.println("Array = " + Arrays.toString(array));
		long startTime = System.nanoTime();
		Arrays.parallelSort(array);
		long endTime = System.nanoTime();
		resultTimebyParallel = endTime - startTime;
		return resultTimebyParallel;
	}

	public static long getSortedTimeBySingle(double[] array) {
		System.out.println("Array = " + Arrays.toString(array));
		long startTime = System.nanoTime();
		Arrays.sort(array);
		long endTime = System.nanoTime();
		resultTimebySingle = endTime - startTime;
		return resultTimebySingle;
	}

	public static void main(String[] args) {
		int arraySize = 0;
		do {
			arraySize++;
			double[] array = DoubleStream.generate(Math::random).limit(arraySize)
					.toArray();
			getSortedTimeByParallel(array.clone());
			getSortedTimeBySingle(array.clone());

		} while (resultTimebyParallel >= resultTimebySingle);
		System.out.println("-----------\nDouble Array size is  " + arraySize
				+ "\nresult time : Single Sort  : "
				+ String.format("%8d", resultTimebySingle)
				+ "\nresult time : Parallel Sort : "
				+ String.format("%8d", resultTimebyParallel) + "\n-----------");
	}
}
