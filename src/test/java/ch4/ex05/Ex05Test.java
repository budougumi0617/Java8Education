/**
 * @file
 * @par File Name:
 * Ex05Test.java
 * @author budougumi0617
 * @date Created on 2014/12/14
 */
package test.java.ch4.ex05;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import main.java.ch4.ex02.Ex02;
import main.java.ch4.ex05.Ex05;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author budougumi0617
 * @note ２つのobserve()メソッドの挙動を検証する
 */
public class Ex05Test {
	Button bt;
	IntegerProperty ip;
	DoubleProperty dp;

	@BeforeClass
	public static void setUpClass() throws InterruptedException {
		System.out.println("About to launch FX App");
		Thread t = new Thread("JavaFX Init Thread") {
			public void run() {
				Application.launch(Ex02.class, new String[0]);
			}
		};
		t.setDaemon(true);
		t.start();
		System.out.println("FX App thread started\n"
				+ "This procedure executes once on this test class");
	}

	@Before
	public void Before() {
		bt = new Button("For Test");
		ip = new SimpleIntegerProperty(0);
		dp = new SimpleDoubleProperty(0d);

	}

	@Test
	public void testSingleObserve() {

		bt.disableProperty().bind(Ex05.observe(t -> t.intValue() <= 0, ip));
		assertTrue(bt.isDisable());
		ip.set(1);
		assertFalse(bt.isDisable());
		ip.set(0);
		assertTrue(bt.isDisable());
	}

	@Test
	public void testMultipleObserve() {

		bt.disableProperty()
				.bind(Ex05.observe((t, u) -> t.intValue() <= 0 || u.doubleValue() <= 0d,
						ip, dp));
		assertTrue(bt.isDisable());
		ip.set(1);
		assertTrue(bt.isDisable());
		ip.set(0);
		assertTrue(bt.isDisable());
		dp.set(1d);
		assertTrue(bt.isDisable());
		ip.set(1);
		dp.set(1d);
		assertFalse(bt.isDisable());
	}
}
