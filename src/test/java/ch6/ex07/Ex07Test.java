/**
 * @file
 * @par File Name:
 * Ex07Test.java
 * @author budougumi0617
 * @date Created on 2015/01/19
 */
package test.java.ch6.ex07;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.ConcurrentHashMap;

import main.java.ch6.ex07.Ex07;

import org.junit.Before;
import org.junit.Test;

/**
 * @author budougumi0617
 * @note Search entry that have the max value in
 *       the map.
 */
public class Ex07Test {
	private final String maxKey = "MAX_KEY";
	ConcurrentHashMap<String, Long> map;

	@Before
	public void before() {
		map = new ConcurrentHashMap<String, Long>();
		map.put("foo", 10L);
		map.put("bar", 20L);
		map.put("hoge", 30L);
	}

	@Test
	public void testMaxValueAndReturnEntry() {
		map.put(maxKey, Long.MAX_VALUE);
		map.put("Dummy", 100L);
		assertThat(Ex07.getKeyHasMaxValue(map), is(maxKey));
		assertThat(Ex07.resultEntries.getKey(), is(maxKey));
		assertThat(Ex07.resultEntries.getValue(), is(Long.MAX_VALUE));
	}

}
