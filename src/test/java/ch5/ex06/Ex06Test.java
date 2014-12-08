/**
 * @file
 * @par File Name:
 * Ex06Test.java
 * @author budougumi0617
 * @date Created on 2014/12/08
 */
package test.java.ch5.ex06;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;

import main.java.ch5.ex06.Ex06;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;

/**
 * @author budougumi0617
 * @note CustomMatcherを利用して20世紀の13日の金曜日か検証する
 */
public class Ex06Test {

	@Test
	public void test() {
		Ex06.generateFridayThe13thStream().forEach(w -> {
			assertThat(w.getDayOfMonth(), is(13));
			assertThat(w.getDayOfWeek(), is(DayOfWeek.FRIDAY));
			assertThat(w.getYear(), IncludeCentury.centuryOf(20));
		});
	}
}

class IncludeCentury extends BaseMatcher<Integer> {
	private int startYear;
	private int endYear;

	IncludeCentury(int century) {
		startYear = (century - 1) * 100 + 1;
		endYear = century * 100;
	}

	@Override
	public boolean matches(Object arg0) {
		Integer actual = (Integer) arg0;
		return startYear <= actual && actual <= endYear;
	}

	@Override
	public void describeTo(Description arg0) {
		arg0.appendText("Between from " + startYear + " to " + endYear);
	}

	public static BaseMatcher<Integer> centuryOf(int year) {
		return new IncludeCentury(year);
	}

}