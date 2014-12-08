/**
 * @file
 * @par File Name:
 * Ex3Test.java
 * @author budougumi0617
 * @date Created on 2014/12/08
 */
package test.java.ch5.ex03;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;

import main.java.ch5.ex03.Ex03;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note nextメソッドにラムダ式を渡してテストを行う。
 */
public class Ex03Test {

	@Test
	public void testExample() {
		assertThat(
				LocalDate.of(2014, 12, 8).with(
						Ex03.next(w -> w.getDayOfWeek().getValue() < 6)),
				is(LocalDate.of(2014, 12, 9)));
	}

	@Test
	public void testGetWeekEnd() {
		assertThat(
				LocalDate.of(2014, 12, 8).with(
						Ex03.next(w -> w.getDayOfWeek().getValue() >= 6)),
				is(LocalDate.of(2014, 12, 13)));
	}

	@Test
	public void testNextProgrammersDay() {
		assertThat(LocalDate.of(2014, 12, 8)
				.with(Ex03.next(w -> w.getDayOfYear() == 256)),
				is(LocalDate.of(2015, 1, 1).plusDays(255)));
	}

}
