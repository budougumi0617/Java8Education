/**
 * @file
 * @par File Name:
 * Ex05Test.java
 * @author budougumi0617
 * @date Created on 2015/01/18
 */
package test.java.ch6.ex05;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Map;
import java.util.Set;

import main.java.ch6.ex05.Ex05;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Ex05Test {
	File file1 = new File("./src/main/resources/ch6/foo.txt");
	File file2 = new File("./src/main/resources/ch6/bar.txt");

	@Test
	public void test() {
		File[] files = { file1, file2 };
		Map<String, Set<File>> result = Ex05.newWordMap(files);
		assertThat(result, hasKey("inBar"));
		Set<File> value = result.get("inBar");
		assertThat(value.size(), is(1));
		assertTrue(value.contains(file2));
		assertThat(result, hasKey("hoge"));
		value = result.get("hoge");
		assertThat(value.size(), is(2));
		assertTrue(value.contains(file1));
		assertTrue(value.contains(file2));
	}
}
