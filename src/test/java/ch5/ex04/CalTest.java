/**
 * @file
 * @par File Name:
 * CalTest.java
 * @author budougumi0617
 * @date Created on 2014/12/22
 */
package test.java.ch5.ex04;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.List;

import main.java.ch5.ex04.Cal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import test.java.util.TestOperation;

/**
 * @author budougumi0617
 * @note Unit test for main.java.ch5.ex04.Cal.
 */
public class CalTest {
	@Before
	public void resetStaticInstance() throws ReflectiveOperationException {
		TestOperation.setPrivateField(Cal.class, "month", 0);
		TestOperation.setPrivateField(Cal.class, "year", 0);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testParseArgment() throws Exception {
		int month = 6;
		int year = 2014;
		String[] args = new String[] { String.valueOf(month), String.valueOf(year) };
		Cal.parseArgment(args);
		try {
			assertThat(TestOperation.getPrivateField(Cal.class, "month"), is(month));
			assertThat(TestOperation.getPrivateField(Cal.class, "year"), is(year));
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testParseArgmentArgLengthZero() throws Exception {
		LocalDate now = LocalDate.now();
		int month = now.getMonthValue();
		int year = now.getYear();
		String[] args = new String[] {};
		Cal.parseArgment(args);
		try {
			assertThat(TestOperation.getPrivateField(Cal.class, "month"), is(month));
			assertThat(TestOperation.getPrivateField(Cal.class, "year"), is(year));
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testJune2014() {
		List<String> result = Cal.getMonthResult(2014, 6);
		result.stream().sequential().forEach(System.out::println);
		assertThat(result.get(0), is("      Jun   2014     "));
		assertThat(result.get(2), is("                    1"));
		assertThat(result.get(7), is(" 30"));
	}
}
