/**
 * @file
 * @par File Name:
 * PairTest.java
 * @author budougumi0617
 * @date Created on 2014/11/24
 */
package test.java.ch3.ex24;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import main.java.ch3.ex24.PairEx;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note no comment
 */
public class PairTest {

	@Test
	public void testFlatMapByBiFunction() {
		Integer element1 = 10;
		Integer element2 = 20;
		PairEx<Integer> pairInteger = new PairEx<Integer>(element1, element2);
		PairEx<String> pairString = pairInteger.flatMapByBiFunction((t1, t2) -> {
			return new PairEx<String>(t1.toString(), t2.toString());
		});

		assertThat(pairString.element1, is(element1.toString()));
		assertThat(pairString.element2, is(element2.toString()));
	}
}
