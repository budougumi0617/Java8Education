/**
 * @file
 * @par File Name:
 * Ex17.java
 * @author budougumi0617
 * @date Created on 2014/11/22
 */
package main.java.ch3.ex17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * @author budougumi0617
 * @note firstとsecondを並列に実行し、
 *       どちらかのメソッドが例外をスローしたらhandlerを呼び出す
 *       doInParrallelAsync(Runnable first,
 *       Runnable second, Consumer<Throwalbe
 *       handler)を実装しなさい。
 */
public class Ex17 {
	public static void doInParrallelAsync(Runnable first, Runnable second,
			Consumer<? super Throwable> handler) {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		threadPool.submit(() -> {
			try {
				first.run();
			} catch (Throwable t) {
				handler.accept(t);
			}
		});
		threadPool.submit(() -> {
			try {
				second.run();
			} catch (Throwable t) {
				handler.accept(t);
			}
		});
		threadPool.shutdown();
	}

	public static void main(String[] args) {

		doInParrallelAsync(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("first = " + i);
			}
		}, () -> {
			for (int i = 0; i < 1; i++) {
				System.out.println("second= " + i);
			}
			int test[] = { 1 };
			int j = test[4];
		}, (t) -> {
			System.out.println("Get throwable by handler");
		});

	}
}
