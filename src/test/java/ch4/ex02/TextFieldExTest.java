/**
 * @file
 * @par File Name:
 * TextFieldExTest.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package test.java.ch4.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import main.java.ch4.ex02.Ex02;
import main.java.ch4.ex02.TextFieldEx;

import org.junit.BeforeClass;
import org.junit.Test;

import test.java.util.TestOperation;

/**
 * @author budougumi0617
 * @note Propertyの遅延初期化ができているか確認する
 */
public class TextFieldExTest {
	TextFieldEx textEx;

	@BeforeClass
	public static void setUpClass() throws InterruptedException {
		// Initialise Java FX
		System.out.printf("About to launch FX App\n");

		Thread t = new Thread("JavaFX Init Thread") {
			public void run() {
				Application.launch(Ex02.class, new String[0]);
			}
		};
		t.setDaemon(true);
		t.start();
		System.out.printf("FX App thread started\n");
		Thread.sleep(500);
	}

	@Test
	public void testPropertyNull() {
		textEx = new TextFieldEx();
		try {
			assertNull(TestOperation.getPrivateField(textEx, "textEx"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPropertyExist() {
		textEx = new TextFieldEx();
		textEx.setTextEx("Exist");
		StringProperty actual;
		try {
			assertNotNull(actual = (StringProperty) TestOperation.getPrivateField(textEx,
					"textEx"));
			assertThat(actual.get(), is("Exist"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
