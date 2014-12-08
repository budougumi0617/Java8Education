/**
 * @file
 * @par File Name:
 * Ex05Test.java
 * @author budougumi0617
 * @date Created on 2014/12/08
 */
package test.java.ch5.ex05;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import main.java.ch5.ex05.Ex05;

import org.junit.Test;

import test.java.util.TestOperation;

/**
 * @author budougumi0617
 * @note privateメソッドをテストすることで、
 *       Ex05.showNumberOfDaysIHaveLived()を検証する
 */
public class Ex05Test {

	@Test
	public void testComputeBetweenDays() {
		Class<?>[] claz = { LocalDate.class, LocalDate.class };
		Object[] args = { LocalDate.of(2014, 12, 8), LocalDate.of(2015, 12, 9) };
		Ex05 ex05 = new Ex05();
		try {
			assertThat((long) TestOperation.doPrivateMethod(ex05, "computeBetweenDays",
					claz, args), is(366L));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testComputeBetweenDaysToLeapYear() {
		Class<?>[] claz = { LocalDate.class, LocalDate.class };
		Object[] args = { LocalDate.of(2011, 12, 8), LocalDate.of(2012, 12, 8) };
		Ex05 ex05 = new Ex05();
		try {
			assertThat((long) TestOperation.doPrivateMethod(ex05, "computeBetweenDays",
					claz, args), is(366L));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testComputeTenThousandDays() {
		Class<?>[] claz = { LocalDate.class, LocalDate.class };
		Object[] args = { LocalDate.of(1986, 6, 17), LocalDate.of(2013, 11, 2) };
		Ex05 ex05 = new Ex05();
		try {
			assertThat((long) TestOperation.doPrivateMethod(ex05, "computeBetweenDays",
					claz, args), is(10_000L));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
