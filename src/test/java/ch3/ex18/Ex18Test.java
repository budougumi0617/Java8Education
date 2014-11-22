/**
 * @file
 * @par File Name:
 * Ex18Test.java
 * @author budougumi0617
 * @date Created on 2014/11/22
 */
package test.java.ch3.ex18;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.function.Function;

import main.java.ch3.ex18.Ex18;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note ランタイムエクセプションが発生している確認する。
 */
public class Ex18Test {

	@Test
	public void testGetException() {
		Function<Integer, String> func = Ex18.unchecked((i) -> {
			int test[] = { 1 };
			int out = test[3];
			return i.toString();
		});
		try {
			String result = func.apply(100);
			fail("Cannot execute line" + result);
		} catch (Exception e) {
			String actual = e.getCause().getClass().getName();
			System.out.println("Got Exception : " + actual);
			assertThat(actual, is(ArrayIndexOutOfBoundsException.class.getName()));
		}

	}

	@Test
	public void testNoThrow() {
		int input = 100;
		Function<Integer, String> func = Ex18.unchecked((i) -> {
			return i.toString();
		});
		try {
			assertThat(func.apply(input), is(String.valueOf(input)));
		} catch (Exception e) {
			fail("Exception is not expected");
		}

	}
}
