/**
 * @file
 * @par File Name:
 * Ex01Test.java
 * @author budougumi0617
 * @date Created on 2014/12/01
 */
package test.java.ch5.ex01;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import main.java.ch5.ex01.Ex01;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Ex01Test {

	private LocalDate getProgrammersDayByPlusDays(int year) {
		return LocalDate.of(year, 1, 1).plusDays(255);
	}

	private void checkProgrammersDays(Function<Integer, LocalDate> f) {
		for (int i = 2000; i < 2100; i++) {
			assertThat(f.apply(i).until(getProgrammersDayByPlusDays(i)), is(Period.ZERO));
		}

	}

	@Test
	public void testPlus() {
		int year = 2014;
		for (int i = 1000; i < 3000; i++) {
			LocalDate programmersDay = getProgrammersDayByPlusDays(year);
			LocalDate actual = Ex01.getProgrammersDayByPlus(year);
			assertThat(actual, is(programmersDay));
		}
	}

	@Test
	public void testOfYearDay() {
		int year = 2014;
		for (int i = 1000; i < 3000; i++) {
			LocalDate programmersDay = getProgrammersDayByPlusDays(year);
			LocalDate actual = Ex01.getProgrammersDayByOfYearDay(year);
			assertThat(actual.until(programmersDay), is(Period.ZERO));
		}
	}

	@Test
	public void testLambda() {

		for (int i = 1000; i < 3000; i++) {
			checkProgrammersDays(y -> LocalDate.ofYearDay(y, 256));
		}
	}

}
