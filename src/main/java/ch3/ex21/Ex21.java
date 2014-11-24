/**
 * @file
 * @par File Name:
 * Ex21.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package main.java.ch3.ex21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

/**
 * @author budougumi0617
 * @note staticメソッドである<T ,U> Future<U>
 *       map(Future<T>, Function<T, U>)を提供しなさい。
 *       Futureインターフェースの全てのメソッドを実装した
 *       無名クラスのオブジェクトを返しなさい。 getメソッドで、関数を呼び出しなさい。
 */
public class Ex21 {
	public static <T, U> Future<U> map(Future<T> future, Function<T, U> func) {
		return new Future<U>() {

			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return future.cancel(mayInterruptIfRunning);
			}

			@Override
			public boolean isCancelled() {
				return future.isCancelled();
			}

			@Override
			public boolean isDone() {
				return future.isDone();
			}

			@Override
			public U get() throws InterruptedException, ExecutionException {
				return func.apply(future.get());
			}

			@Override
			public U get(long timeout, TimeUnit unit) throws InterruptedException,
					ExecutionException, TimeoutException {
				return func.apply(future.get(timeout, unit));
			}

		};
	}
}
