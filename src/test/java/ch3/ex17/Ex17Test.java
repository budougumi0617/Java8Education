/**
 * @file
 * @par File Name:
 * Ex17Test.java
 * @author budougumi0617
 * @date Created on 2014/11/22
 */
package test.java.ch3.ex17;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.atomic.AtomicInteger;

import main.java.ch3.ex17.Ex17;

import org.junit.Before;
import org.junit.Test;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Ex17Test {
	String actual = "No throw";
	static final String expected = "No throw";
	AtomicInteger countEndRunnable = new AtomicInteger();

	@Before
	public void before() {
		actual = expected;
		countEndRunnable.set(0);
	}

	@Test
	public void testNoThrow() {
		Ex17.doInParrallelAsync(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("first = " + i);
			}
			countEndRunnable.incrementAndGet();
		}, () -> {
			for (int i = 0; i < 1; i++) {
				System.out.println("second= " + i);
			}
			countEndRunnable.incrementAndGet();
		}, (t) -> {
			System.out.println("Get throwable");
			actual = t.getClass().getName();
			countEndRunnable.incrementAndGet();
		});
		while (countEndRunnable.get() != 2) {
		}
		;
		assertThat(actual, is(expected));
	}

	@Test
	public void testFirstThrow() {
		Ex17.doInParrallelAsync(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("first = " + i);
			}
			int test[] = { 1 };
			int j = test[4];
			countEndRunnable.incrementAndGet();
		}, () -> {
			for (int i = 0; i < 1; i++) {
				System.out.println("second= " + i);
			}
			countEndRunnable.incrementAndGet();
		}, (t) -> {
			System.out.println("Get throwable");
			actual = t.getClass().getName();
			countEndRunnable.incrementAndGet();
		});
		while (countEndRunnable.get() != 2) {
		}
		;
		assertThat(actual, is(ArrayIndexOutOfBoundsException.class.getName()));
	}

	@Test
	public void testSecondThrow() {
		Ex17.doInParrallelAsync(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("first = " + i);
			}
			countEndRunnable.incrementAndGet();
		}, () -> {
			for (int i = 0; i < 1; i++) {
				System.out.println("second= " + i);
			}
			int test[] = { 1 };
			int j = test[4];
			countEndRunnable.incrementAndGet();
		}, (t) -> {
			System.out.println("Get throwable");
			actual = t.getClass().getName();
			countEndRunnable.incrementAndGet();
		});
		while (countEndRunnable.get() != 2) {
		}
		;
		assertThat(actual, is(ArrayIndexOutOfBoundsException.class.getName()));
	}

	@Test
	public void testBothThrow() {
		Ex17.doInParrallelAsync(() -> {
			System.out.println("testBothThrow first");
			int test[] = { 1 };
			int j = test[4];
		}, () -> {
			System.out.println("testBothThrow second");
			int test[] = { 1 };
			int j = test[4];
		}, (t) -> {
			System.out.println("Get throwable");
			actual = t.getClass().getName();
			countEndRunnable.incrementAndGet();
		});
		while (countEndRunnable.get() != 2) {
		}
		;
		assertThat(actual, is(ArrayIndexOutOfBoundsException.class.getName()));
	}
}
