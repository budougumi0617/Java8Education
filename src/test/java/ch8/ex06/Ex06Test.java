/**
 * @file
 * @par File Name:
 * Ex06Test.java
 * @author budougumi0617
 * @date Created on 2015/03/17
 */
package test.java.ch8.ex06;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import main.java.ch8.ex06.Ex06;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note Confirm result of original comparator.
 */
public class Ex06Test {
	final double x = 10.;
	final double y = 20.;
	final double w = 30.;
	final double h = 40.;

	@Test
	public void samePoint2D() {
		Point2D first = new Point2D(x, y);
		Point2D second = new Point2D(x, y);
		assertThat(Ex06.comparePoint2D().compare(first, second), is(0));
	}

	@Test
	public void highSecondPoint2D() {
		Point2D first = new Point2D(x, y);
		Point2D second = new Point2D(x, y + 1.);
		assertThat(Ex06.comparePoint2D().compare(first, second), is(-1));
	}

	@Test
	public void lowSecondPoint2D() {
		Point2D first = new Point2D(x, y);
		Point2D second = new Point2D(x, y - 1.);
		assertThat(Ex06.comparePoint2D().compare(first, second), is(1));
	}

	@Test
	public void nearSecondPoint2D() {
		Point2D first = new Point2D(x - 1., y);
		Point2D second = new Point2D(x, y);
		assertThat(Ex06.comparePoint2D().compare(first, second), is(-1));
	}

	@Test
	public void farSecondPoint2D() {
		Point2D first = new Point2D(x, y);
		Point2D second = new Point2D(x + 1., y);
		assertThat(Ex06.comparePoint2D().compare(first, second), is(-1));
	}

	@Test
	public void highFirstRectangle2D() {
		Rectangle2D first = new Rectangle2D(x, y, w, h + 1);
		Rectangle2D second = new Rectangle2D(x, y, w, h);
		assertThat(Ex06.compareRectangle2D().compare(first, second), is(1));
	}

	@Test
	public void lowFirstRectangle2D() {
		Rectangle2D first = new Rectangle2D(x, y, w, h);
		Rectangle2D second = new Rectangle2D(x, y, w, h + 1);
		assertThat(Ex06.compareRectangle2D().compare(first, second), is(-1));
	}

	@Test
	public void wideFirstRectangle2D() {
		Rectangle2D first = new Rectangle2D(x, y, w + 1, h);
		Rectangle2D second = new Rectangle2D(x, y, w, h);
		assertThat(Ex06.compareRectangle2D().compare(first, second), is(1));
	}

	@Test
	public void narrowFirstRectangle2D() {
		Rectangle2D first = new Rectangle2D(x, y, w - 1, h);
		Rectangle2D second = new Rectangle2D(x, y, w, h);
		assertThat(Ex06.compareRectangle2D().compare(first, second), is(-1));
	}
}
