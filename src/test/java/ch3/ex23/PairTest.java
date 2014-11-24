/**
 * @file
 * @par File Name:
 * PairTest.java
 * @author budougumi0617
 * @date Created on 2014/11/24
 */
package test.java.ch3.ex23;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import main.java.ch3.ex23.Pair;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note Pairクラスと作成したmap操作が意図通りに実装されているか検証する。
 */
public class PairTest {

	@Test
	public void testMap() {
		Integer element1 = 10;
		Integer element2 = 20;
		Pair<Integer> pairInteger = new Pair<Integer>(element1, element2);
		Pair<String> pairString = pairInteger.map(t -> t.toString());

		assertThat(pairString.element1, is(element1.toString()));
		assertThat(pairString.element2, is(element2.toString()));
	}

}
