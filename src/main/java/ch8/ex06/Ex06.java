/**
 * @file
 * @par File Name:
 * Ex06.java
 * @author budougumi0617
 * @date Created on 2015/03/17
 */
package main.java.ch8.ex06;

import java.util.Comparator;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex06 {

	public static Comparator<Point2D> comparePoint2D() {
		return Comparator.comparingDouble(Point2D::getX).thenComparing(Point2D::getY);
	}

	public static Comparator<Rectangle2D> compareRectangle2D() {
		return Comparator.comparingDouble(Rectangle2D::getMinX)
				.thenComparingDouble(Rectangle2D::getMinY)
				.thenComparingDouble(Rectangle2D::getWidth)
				.thenComparingDouble(Rectangle2D::getHeight);
	}
}
