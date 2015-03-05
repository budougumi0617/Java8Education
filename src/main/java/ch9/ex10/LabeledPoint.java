/**
 * @file
 * @par File Name:
 * LabeledPoint.java
 * @author budougumi0617
 * @date Created on 2015/03/02
 */
package main.java.ch9.ex10;

import java.util.Objects;

/**
 * @author budougumi0617
 * @note 練習問題9のLabeledPointクラスに
 *       compareToメソッドを実装しなさい。
 */
public class LabeledPoint {

	private String label;
	private int x;
	private int y;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(label, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		LabeledPoint other = (LabeledPoint) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label)) {
			return false;
		}
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int compareTo(LabeledPoint other) {
		int diff = this.label.compareTo(other.label);
		if (diff != 0)
			return diff;
		diff = Integer.compare(x, other.x);
		if (diff != 0)
			return diff;
		return Integer.compare(y, other.y);
	}
}
