/**
 * @file
 * @par File Name:
 * Ex22Test.java
 * @author budougumi0617
 * @date Created on 2014/11/24
 */
package test.java.ch3.ex22;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note thenComposeとthenCombineの仕様確認。
 */
public class Ex22Test {
	public String convertString(Integer i) {
		return i.toString();
	}

	@Test
	public void testCompose() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		Integer integerElement = 100;
		String expected = integerElement.toString();
		System.out.println("task start");
		CompletableFuture<Integer> cfInteger = CompletableFuture.supplyAsync(
				() -> integerElement, service);
		CompletableFuture<String> cfString = cfInteger.thenCompose(t -> CompletableFuture
				.supplyAsync(() -> t.toString(), service));
		try {
			assertThat(cfString.get(), is(expected));
			assertTrue(cfString.isDone());
			assertFalse(cfString.isCancelled());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("task end");

		service.shutdown();
	}

	@Test
	public void testCombine() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		Integer integerElement = 100;
		Double doubleElement = 10d;
		String expected = integerElement.toString() + " " + doubleElement.toString();
		System.out.println("task start");
		CompletableFuture<Integer> cfInteger = CompletableFuture.supplyAsync(
				() -> integerElement, service);
		CompletableFuture<Double> cfDouble = CompletableFuture.supplyAsync(
				() -> doubleElement, service);
		CompletableFuture<String> cfString = cfInteger.thenCombine(cfDouble,
				(t, u) -> t.toString() + " " + u.toString());
		try {
			assertThat(cfString.get(), is(expected));
			assertTrue(cfString.isDone());
			assertFalse(cfString.isCancelled());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("task end");

		service.shutdown();
	}

}
