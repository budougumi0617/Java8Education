/**
 * @file
 * @par File Name:
 * Ex02Test.java
 * @author budougumi0617
 * @date Created on 2015/03/01
 */
package test.java.ch8.ex02;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import main.java.ch8.ex02.Ex02;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note 
 *       Math.negateExact(n)が例外をスローすることになる整数nの値は何ですか
 *       （ヒント:１つの値しか該当しません。）
 */
public class Ex02Test {

	@Test(expected = ArithmeticException.class)
	public void testNegateValue() {
		Ex02.getNegate(Integer.MIN_VALUE);
	}

	@Test
	public void testNoException() {
		IntStream.range(Integer.MIN_VALUE + 1, Integer.MAX_VALUE).parallel()
				.forEach(i -> {
					Ex02.getNegate(i);
				});
	}

	@Test(expected = ArithmeticException.class)
	public void testNegateValueLong() {
		Ex02.getNegateLong(Long.MIN_VALUE);
	}

	// @Test This test takes too long
	public void testNoExceptionLong() {
		LongStream.range(Long.MIN_VALUE + 1, Long.MAX_VALUE).parallel()
				.forEach(i -> System.out.println(i));
	}
}
