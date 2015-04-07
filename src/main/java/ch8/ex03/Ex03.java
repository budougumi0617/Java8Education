/**
 * @file
 * @par File Name:
 * Ex03.java
 * @author budougumi0617
 * @date Created on 2015/04/07
 */
package main.java.ch8.ex03;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex03 {

	public static int gcdByPercent(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		return b == 0 ? a : gcdByPercent(b, a % b);

	}

	public static int gcdByFloorMod(int a, int b) {
		return b == 0 ? a : gcdByFloorMod(b, Math.floorMod(a, Math.abs(b)));
	}

	public static int gcdByRem(int a, int b) {
		return b == 0 ? a : gcdByRem(b, rem(a, b));
	}

	private static int rem(int a, int b) {
		return Math.abs(a) % Math.abs(b);
	}
}
