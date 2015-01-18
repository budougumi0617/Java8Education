/**
 * @file
 * @par File Name:
 * Ex03Test.java
 * @author budougumi0617
 * @date Created on 2015/01/18
 */
package test.java.ch6.ex03;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import main.java.ch6.ex03.Ex03;

import org.junit.Before;
import org.junit.Test;

/**
 * @author budougumi0617
 * @note Confirm methods of ch06.ex03.Ex03
 */
public class Ex03Test {
	private Ex03 target;
	private final int THREAD_NUM = 3;

	@Before
	public void bedore() {
		target = new Ex03(THREAD_NUM);
	}

	@Test
	public void testAtomicLong() {
		long resultTime = target.incrementAtomicLong();
		assertThat(resultTime, is(not(-1)));
		assertThat(target.getAtomicLongValue(),
				is((long) (THREAD_NUM * Ex03.INCREMENTAL_NUM)));
		assertThat(target.getLongAdderValue(), is(0L));
	}

	@Test
	public void testLongAdder() {
		long resultTime = target.incrementLongAdder();
		assertThat(resultTime, is(not(-1)));
		assertThat(target.getAtomicLongValue(), is(0L));
		assertThat(target.getLongAdderValue(),
				is((long) (THREAD_NUM * Ex03.INCREMENTAL_NUM)));
	}
}
