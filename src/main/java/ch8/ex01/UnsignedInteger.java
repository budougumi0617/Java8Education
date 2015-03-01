/**
 * @file
 * @par File Name:
 * Ex01.java
 * @author budougumi0617
 * @date Created on 2015/03/01
 */
package main.java.ch8.ex01;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class UnsignedInteger {
	public static int add(int i, int j) {
		return i + j;
	}

	public static int sub(int i, int j) {
		return i - j;
	}

	public static int divide(int i, int j) {
		return Integer.divideUnsigned(i, j);
	}

	public static int compare(int i, int j) {
		return Integer.compareUnsigned(i, j);
	}

	public static String showResult(int i) {
		return Integer.toUnsignedString(i);
	}

	public static void main(String[] args) {
		int max = Integer.MAX_VALUE;
		System.out.println("max = " + max);
		System.out.println("max / 10 = " + showResult(divide(max, 10)));
		System.out.println("max + 10 = " + showResult(add(max, 10)));
		System.out.println("max / 10 = " + showResult(divide(max + 10, 10)));
		System.out
				.println("Compare Integer.MAX_VALUE + 100 and  Integer.MAX_VALUE + 10 :"
						+ showResult(compare(max + 100, max + 10)));
	}
}
