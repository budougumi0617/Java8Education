/**
 * @file
 * @par File Name:
 * Ex02.java
 * @author budougumi0617
 * @date Created on 2015/03/01
 */
package main.java.ch8.ex02;

/**
 * @author budougumi0617
 * @note 
 *       Math.negateExact(n)が例外をスローすることになる整数nの値は何ですか
 *       （ヒント:１つの値しか該当しません。）
 */
public class Ex02 {

	public static int getNegate(int a) {
		return Math.negateExact(a);
	}

	public static long getNegateLong(long a) {
		return Math.negateExact(a);
	}
}
