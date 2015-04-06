/**
 * @file
 * @par File Name:
 * Ex14.java
 * @author budougumi0617
 * @date Created on 2015/04/06
 */
package main.java.ch8.ex14;

import java.util.Objects;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex14 {
	private final String s;

	public Ex14(String obj) {
		this.s = Objects.requireNonNull(obj, "Constructor cannot accepts null");
	}

	public static void main(String[] args) {
		System.out.println(new Ex14("Non null\n").toString());
		System.out.println(new Ex14(null).toString());
	}

	@Override
	public String toString() {
		return s;
	}
}
