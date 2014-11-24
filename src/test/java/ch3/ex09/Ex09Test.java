/**
 * @file
 * @par File Name:
 * Ex09Test.java
 * @author budougumi0617
 * @date Created on 2014/11/24
 */
package test.java.ch3.ex09;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import main.java.ch3.ex09.Ex09;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note ただしく比較ができるかテストする。
 */
public class Ex09Test {

	public class Data {
		public String key1;
		public int key2;
		public String value1;

		public Data(String key1, int key2, String value1) {
			this.key1 = key1;
			this.key2 = key2;
			this.value1 = value1;
		}
	}

	@Test
	public void testKey1() {
		List<Data> datas = Arrays.asList(new Data("def", 999, "abc"), new Data("abc",
				777, "def"), new Data("abc", 111, "zzz"));

		Collections.sort(datas, Ex09.lexicographicComparator("key1", "key2", "value1"));
		assertThat(datas.get(0).key1, is("abc"));
		assertThat(datas.get(1).key2, is(111));
		assertThat(datas.get(2).key1, is("def"));
	}

	@Test
	public void testValue1() {
		List<Data> datas = Arrays.asList(new Data("def", 999, "abc"), new Data("abc",
				777, "def"), new Data("abc", 111, "zzz"));

		Collections.sort(datas, Ex09.lexicographicComparator("value1", "key2", "key1"));

		assertThat(datas.get(0).value1, is("abc"));
		assertThat(datas.get(1).value1, is("def"));
		assertThat(datas.get(2).value1, is("zzz"));
	}

	@Test
	public void testThird() {
		List<Data> datas = Arrays.asList(new Data("def", 999, "abc"), new Data("def",
				222, "abc"), new Data("def", 111, "abc"));

		Collections.sort(datas, Ex09.lexicographicComparator("value1", "key1", "key2"));

		assertThat(datas.get(0).key2, is(999));
		assertThat(datas.get(1).key2, is(222));
		assertThat(datas.get(2).key2, is(111));
	}
}
