/**
 * @file
 * @par File Name:
 * Ex08.java
 * @author budougumi0617
 * @date Created on 2015/03/02
 */
package main.java.ch9.ex08;

/**
 * @author budougumi0617
 * @note 224ページの9.3.3節「数値型を比較する」
 *       のPointクラスのcompareToメソッドを
 *       Integer.compareToを使用せずに実装しなさい。
 */
public class Point {
	private int x;
	private int y;

	public static int compare(int x, int y) {
		return (x > y) ? -1 : ((x == y) ? 0 : 1);
	}

	public int compareTo(Point other) {
		int diff = compare(x, other.x);
		if (diff != 0)
			return diff;
		return compare(y, other.y);
	}
}
