/**
 * @file
 * @par File Name:
 * Ex04.java
 * @author budougumi0617
 * @date Created on 2015/01/18
 */
package main.java.ch6.ex04;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

/**
 * @author budougumi0617
 * @note 
 *       LongAccumulatorを使用して、要素の最大値あるいは最小値を計算しなさい。
 */
public class Ex04 {

	public static long computeMaxValue(LongStream longStream) {
		return coreMethod((x, y) -> x > y ? x : y, longStream);
	}

	public static long computeMinValue(LongStream longStream) {
		return coreMethod((x, y) -> x < y ? x : y, longStream);
	}

	public static long coreMethod(LongBinaryOperator op, LongStream st) {
		LongAccumulator accumulator = new LongAccumulator(op, 0L);
		st.parallel().forEach(x -> accumulator.accumulate(x));
		return accumulator.get();
	}

	public static void main(String[] args) {
		LongStream input = LongStream.of(-100L, 0L, 100L);
		System.out.println("Max value : " + computeMaxValue(input));
		input = LongStream.of(-100L, 0L, 100L);
		System.out.println("Min value : " + computeMinValue(input));
	}
}
