/**
 * @file
 * @par File Name:
 * Ex20Test.java
 * @author budougumi0617
 * @date Created on 2014/11/24
 */
package test.java.ch3.ex20;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import main.java.ch3.ex20.Ex20;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note Ex20.mapメソッドの動作確認
 */
public class Ex20Test {

	@Test
	public void test() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		List<String> actual = Ex20.map(list, (t) -> t.toString());
		for (int i = 0; i < list.size(); i++) {
			assertThat(actual.get(i), is(list.get(i).toString()));
		}
	}
}
