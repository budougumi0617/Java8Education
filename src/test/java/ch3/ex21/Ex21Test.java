/**
 * @file
 * @par File Name:
 * Ex21Test.java
 * @author budougumi0617
 * @date Created on 2014/11/24
 */
package test.java.ch3.ex21;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import main.java.ch3.ex21.Ex21;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note Ex21.mapメソッドの動作確認
 */
public class Ex21Test {

	@Test
	public void testGet() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		Integer result = 100;
		System.out.println("task start");

		Future<String> actual = Ex21.map(service.submit(() -> result), t -> t.toString());
		try {
			assertThat(actual.get(), is(result.toString()));
			assertTrue(actual.isDone());
			assertFalse(actual.isCancelled());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("task end");

		service.shutdown();
	}

	@Test
	public void testGetWithTimeOut() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		Integer result = 100;
		System.out.println("task start");

		Future<String> actual = Ex21.map(service.submit(() -> {
			Thread.sleep(1_000);
			return result;
		}), t -> t.toString());
		try {
			assertThat(actual.get(2, TimeUnit.SECONDS), is(result.toString()));
			assertTrue(actual.isDone());
			assertFalse(actual.isCancelled());
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		System.out.println("task end");

		service.shutdown();
	}
}
