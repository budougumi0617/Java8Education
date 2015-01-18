/**
 * @file
 * @par File Name:
 * Ex04Test.java
 * @author budougumi0617
 * @date Created on 2015/01/18
 */
package test.java.ch6.ex04;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.stream.LongStream;

import main.java.ch6.ex04.Ex04;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note Confirm methods of ch06.ex04.Ex04
 */
public class Ex04Test {

	@Test
	public void testMaxValue() {
		LongStream input = LongStream.generate(() -> (long) (Math.random())).limit(100);
		input = LongStream.concat(input, LongStream.of(Long.MAX_VALUE));
		assertThat(Ex04.computeMaxValue(input), is(Long.MAX_VALUE));
	}

	@Test
	public void testMinValue() {
		LongStream input = LongStream.generate(() -> (long) (Math.random())).limit(100);
		input = LongStream.concat(input, LongStream.of(Long.MIN_VALUE));
		assertThat(Ex04.computeMinValue(input), is(Long.MIN_VALUE));
	}
}
