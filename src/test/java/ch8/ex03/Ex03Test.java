/**
 * @file
 * @par File Name:
 * Ex03Test.java
 * @author budougumi0617
 * @date Created on 2015/04/07
 */
package test.java.ch8.ex03;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import main.java.ch8.ex03.Ex03;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note Confirm each gcd functions
 */
public class Ex03Test {

	@Test
	public void confirmGcdByPercent() {
		assertThat(Ex03.gcdByPercent(-100, 3), is(1));
		assertThat(Ex03.gcdByPercent(100, -3), is(1));
		assertThat(Ex03.gcdByPercent(-100, -3), is(1));
	}

	@Test
	public void confirmGcdByFloorMod() {
		assertThat(Ex03.gcdByFloorMod(-100, 3), is(1));
		assertThat(Ex03.gcdByFloorMod(100, -3), is(1));
		assertThat(Ex03.gcdByFloorMod(-100, -3), is(1));
	}

	@Test
	public void confirmGcdByRem() {
		assertThat(Ex03.gcdByRem(-100, 3), is(1));
		assertThat(Ex03.gcdByRem(100, -3), is(1));
		assertThat(Ex03.gcdByRem(-100, -3), is(1));
	}
}
