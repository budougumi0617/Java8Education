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

import main.java.ch2.ex02.Ex02;

import org.junit.Before;
import org.junit.Test;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Ex02Test {
	Ex02 targetClass;

	@Before
	public void prepare() {
		targetClass = new Ex02();
	}

	@Test
	public void noThrowException() {
		assertNotNull(targetClass);
		try {
			List<String> words = targetClass.getWordsList();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void checkFilterCallCount() {
		assertNotNull(targetClass);
		try {
			List<String> words = targetClass.getWordsList();
			assertThat(targetClass.searchLongWord(words), is(Ex02.LIMIT_COUNT));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

}
