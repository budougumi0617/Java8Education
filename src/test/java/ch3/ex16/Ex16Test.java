/**
 * @file
 * @par File Name:
 * Ex16Test.java
 * @author budougumi0617
 * @date Created on 2014/11/22
 */
package test.java.ch3.ex16;

import static org.junit.Assert.assertNull;
import main.java.ch3.ex16.Ex16;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note doIntOrderAsyncのユースケースを作成する TODO
 *       ユースケースが微妙
 */
public class Ex16Test {

	@Test
	public void testGetInt() {
		String inputStrings[] = { "10", "20", "30", "@@", "100" };
		for (String s : inputStrings) {
			Ex16.doIntOrderAsync(() -> {
				int i = Integer.parseInt(s);
				System.out.println("After parse : " + i);
				return i;
			}, (i, t) -> {
				assertNull(i);
				System.out.println("Execption name : " + t.toString());
				System.out.println("After parse : " + i);
			});
		}
	}
}
