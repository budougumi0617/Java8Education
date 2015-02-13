/**
 * @file
 * @par File Name:
 * Ex11Test.java
 * @author budougumi0617
 * @date Created on 2015/02/12
 */
package test.java.ch6.ex11;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.PasswordAuthentication;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import main.java.ch6.ex11.Ex11;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.java.util.StandardInputSnatcher;

/**
 * @author budougumi0617
 * @note Confirm function of
 *       main.java.ch6.ex11.Ex11
 */
public class Ex11Test {
	private StandardInputSnatcher in = new StandardInputSnatcher();

	@Before
	public void before() {
		System.setIn(in);
		Ex11.input = new Scanner(in);
	}

	@After
	public void after() {
		System.setIn(null);
	}

	@Test
	public void validatePasswordReturnTrue() {
		PasswordAuthentication pa = new PasswordAuthentication("userName",
				Ex11.CORRECT_PASSWORD.toCharArray());
		assertTrue(Ex11.validatePassword(pa));
	}

	@Test
	public void validatePasswordReturnFalse() {
		PasswordAuthentication pa = new PasswordAuthentication("userName",
				"secretFalse".toCharArray());
		assertFalse(Ex11.validatePassword(pa));
	}

	@Test
	public void getPasswordAuthenticationRetrunObject() {
		String usrName = "userName";
		String password = "password";
		in.inputln(usrName);
		in.inputln(password);

		PasswordAuthentication pa = Ex11.getPasswordAuthentication();
		assertThat(pa.getUserName(), is(usrName));
		assertThat(pa.getPassword(), is(password.toCharArray()));
	}

	@Test
	public void repeatOnce() throws Exception {
		AtomicInteger zero = new AtomicInteger();
		assertThat(Ex11.repeat(() -> zero.incrementAndGet(), i -> true).get(), is(1));
	}

	@Test
	public void repeatTenth() throws Exception {
		AtomicInteger zero = new AtomicInteger();
		assertThat(Ex11.repeat(() -> zero.incrementAndGet(), i -> i == 10).get(), is(10));
	}
}
