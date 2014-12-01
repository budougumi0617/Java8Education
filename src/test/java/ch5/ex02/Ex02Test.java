/**
 * @file
 * @par File Name:
 * Ex02Test.java
 * @author budougumi0617
 * @date Created on 2014/12/01
 */
package test.java.ch5.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note LocalDate.of(2000, 2,29)に
 *       １年を加算すると何が置きますか。4年を加算するとどうですか。
 *       さらに、１年を４回加算するとどうなりますか。
 */
public class Ex02Test {

	@Test
	public void test() {
		LocalDate startDay = LocalDate.of(2000, 2, 29);
		assertThat(startDay.plusYears(1L), is(LocalDate.of(2001, 2, 28)));
		assertThat(startDay.plusYears(4L), is(LocalDate.of(2004, 2, 29)));
		assertThat(startDay.plusYears(1L).plusYears(1L).plusYears(1L).plusYears(1L),
				is(LocalDate.of(2004, 2, 28)));

	}
}
