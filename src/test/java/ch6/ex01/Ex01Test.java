/**
 * @file
 * @par File Name:
 * Ex01Test.java
 * @author budougumi0617
 * @date Created on 2015/01/10
 */
package test.java.ch6.ex01;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.stream.Stream;

import main.java.ch6.ex01.Ex01;

import org.junit.Before;
import org.junit.Test;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Ex01Test {
	@Before
	public void prepare() {
		Ex01.maxLengthString.set(null);
	}

	@Test
	public void testUpdateStringFirst() {
		String result = "result";
		Ex01.updateString(result);
		assertThat(Ex01.maxLengthString.get(), is(result));
	}

	@Test
	public void testCompareString() {
		String oldString = "shortString";
		String newString = "loooooongString";
		Ex01.updateString(oldString);
		Ex01.updateString(newString);
		assertThat(Ex01.maxLengthString.get(), is(newString));
	}

	@Test
	public void testCompareString2() {
		String oldString = "loooooongString";
		String newString = "shortString";
		Ex01.updateString(oldString);
		Ex01.updateString(newString);
		assertThat(Ex01.maxLengthString.get(), is(oldString));
	}

	@Test
	public void testMainlyMethod() throws Exception {
		String longestString = "loooooongString";
		Stream<String> inputStream = Stream.of("test", "test", longestString,
				"midiamString");
		assertThat(Ex01.searchMaxLengthStringByParalell(inputStream), is(longestString));
	}
}
