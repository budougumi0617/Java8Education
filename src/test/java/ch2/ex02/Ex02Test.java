/**
 * @file
 * @par File Name:
 * Ex02Test.java
 * @author budougumi0617
 * @date Created on 2014/10/02
 */
package test.java.ch2.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import main.java.ch2.ex02.SearchLongWordsOnlyFive;

import org.junit.Before;
import org.junit.Test;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Ex02Test {
	SearchLongWordsOnlyFive targetClass;

	@Before
	public void prepare() {
		targetClass = new SearchLongWordsOnlyFive();
	}

	@Test
	public void prepareTest() {
		assertNotNull(targetClass);
		try {
			List<String> words = targetClass.getWordsList();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void checkSameResult() {
		List<String> words = null;
		try {
			words = targetClass.getWordsList();
		} catch (IOException e) {
			fail();
		}
		assertThat(targetClass.countLongWordByParallel(words),
				is(targetClass.countLongWordBySingle(words)));
	}

}
