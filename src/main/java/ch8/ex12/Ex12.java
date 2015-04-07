/**
 * @file
 * @par File Name:
 * Ex12.java
 * @author budougumi0617
 * @date Created on 2015/04/07
 */
package main.java.ch8.ex12;

/**
 * @author budougumi0617
 * @note For confirm an annotation.
 */
public class Ex12 {

	@TestCase(params = 10, expected = 100)
	@TestCase(params = 7, expected = 49)
	public static int targetMethod(int i) {
		return i * i;
	}

}
