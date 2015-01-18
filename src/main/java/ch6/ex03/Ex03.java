/**
 * @file
 * @par File Name:
 * Ex03.java
 * @author budougumi0617
 * @date Created on 2015/01/18
 */
package main.java.ch6.ex03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author budougumi0617
 * @note 1,000個のスレッドを生成し、各スレッドは、
 *       ある１つのカウンターを100,000回だけ1ずつ増加させます。
 *       AtomicLongとLongAdderを使用した場合の性能を比較しなさい。
 * 
 */
public class Ex03 {
	private AtomicLong counterByAtomicLong;
	private LongAdder counterByLongAdder;
	private long resultTime;
	public static final int THREAD_NUM = 1_000;
	public static final int INCREMENTAL_NUM = 100_000;
	private final int threadNum;

	public Ex03() {
		counterByAtomicLong = new AtomicLong();
		counterByLongAdder = new LongAdder();
		resultTime = 0;
		threadNum = THREAD_NUM;
	}

	public Ex03(int threadNum) {

		counterByAtomicLong = new AtomicLong();
		counterByLongAdder = new LongAdder();
		resultTime = 0;
		this.threadNum = threadNum;
	}

	public long incrementAtomicLong() {
		return taskExecute(() -> {
			for (int j = 0; j < INCREMENTAL_NUM; j++) {
				counterByAtomicLong.incrementAndGet();
			}
		});
	}

	public long incrementLongAdder() {
		return taskExecute(() -> {
			for (int j = 0; j < INCREMENTAL_NUM; j++) {
				counterByLongAdder.increment();
			}
		});
	}

	public long taskExecute(Runnable task) {
		long startTime = System.nanoTime();
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int i = 0; i < threadNum; i++) {
			service.submit(task);
		}
		try {
			service.shutdown();
			if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
				service.shutdownNow();
				return -1;
			}
		} catch (InterruptedException e) {
			System.out.println("awaitTermination interrupted: " + e);
			service.shutdownNow();
		}
		long endTime = System.nanoTime();
		resultTime = endTime - startTime;
		return resultTime;
	}

	public long getAtomicLongValue() {
		return counterByAtomicLong.get();
	}

	public long getLongAdderValue() {
		return counterByLongAdder.sum();
	}

	public static void main(String[] args) {
		Ex03 ex03 = new Ex03();
		long timeByAtomicLong = ex03.incrementAtomicLong();
		long timeByLongAdder = ex03.incrementLongAdder();
		System.out.println("Result :\nBy AtomicLong :" + timeByAtomicLong / 1_000L
				+ " msec\n" + "By LongAdder : " + timeByLongAdder / 1_000L + " msec");
	}
}
