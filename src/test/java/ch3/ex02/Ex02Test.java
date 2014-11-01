/**
 * @file
 * @par File Name:
 * Ex03Test.java
 * @author budougumi0617
 * @date Created on 2014/10/30
 */
package test.java.ch3.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import main.java.ch3.ex02.Ex02;

import org.junit.Before;
import org.junit.Test;

/**
 * @author budougumi0617
 * @note パラレルストリームで加算処理をしても
 *       Lockによって正しく加算ができているか検証する
 */
public class Ex02Test {
	static int test = 0;

	@Before
	public void prepare() {
		test = 0;
	}

	@Test
	public void test() {
		Lock lock = new ReentrantLock();
		int limit_count = 1_000;
		/*
		 * IntStream.iterate(1, f ->
		 * f).limit(100).parallel().forEach(n -> {
		 * test = test + n; });
		 */
		IntStream.iterate(1, f -> f).limit(limit_count).parallel()
				.forEach(n -> {
					Ex02.withLock(lock, () -> {
						test = test + n;
					});
				});
		assertThat(limit_count, is(test));
		System.out.println("result : " + test);
	}
}
