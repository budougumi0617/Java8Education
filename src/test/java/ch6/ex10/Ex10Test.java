/**
 * @file
 * @par File Name:
 * Ex10Test.java
 * @author budougumi0617
 * @date Created on 2015/02/11
 */
package test.java.ch6.ex10;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import main.java.ch6.ex10.Ex10;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note Verify function of ch06.ex10.Ex10
 */
public class Ex10Test {

	@Test
	public void getLinksReturnEmptyList() {
		String page = "<a href=\"test string <a \"hre>";
		List<String> result = Ex10.getLinks(page);
		assertTrue(result.isEmpty());
	}

	@Test
	public void getLinksReturnListIncludingUrlString() throws Exception {
		String page = "<a href=\"test string\">";
		List<String> result = Ex10.getLinks(page);
		assertThat(result.size(), is(1));
		assertThat(result.get(0), is("test string"));
	}

	@Test
	public void getURLInputCreateURL() throws Exception {
		String input = "http://foo";
		CompletableFuture<URL> result = Ex10.getURLInput(input);
		assertThat(result.get().toString(), is(input));
	}
}
