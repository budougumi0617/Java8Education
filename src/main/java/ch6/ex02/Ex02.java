/**
 * @file
 * @par File Name:
 * Ex2.java
 * @author budougumi0617
 * @date Created on 2015/02/13
 */
package main.java.ch6.ex02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author budougumi0617
 * @note Synchronize test to LongAdder
 */
public class Ex02 {
	public LongAdder longAdder;
	static int counter = 0;

	public Ex02() {
		longAdder = new LongAdder();
	}

	public synchronized long generateIdBySync() {
		longAdder.increment();
		return longAdder.longValue();
	}

	public long generateIdByNotSync() {
		longAdder.increment();
		return longAdder.longValue();
	}

	public static void main(String[] args) throws InterruptedException {
		Ex02 ex02 = new Ex02();

		int threads = 100;
		int limit = 1_000;
		List<Long> idList = Collections.synchronizedList(new ArrayList<Long>());
		Set<Long> idSet = new HashSet<Long>();
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int th = 0; th < threads; th++) {
			pool.submit(() -> {
				for (int i = 0; i < limit; i++) {
					idList.add(ex02.generateIdByNotSync());
				}
			});
		}

		pool.shutdown();
		pool.awaitTermination(10, TimeUnit.MINUTES);
		idList.stream().sequential().forEach(id -> {
			if (idSet.add(id) == false) {
				counter++;
			}
		});
		System.out.println("generateIdByNotSync() generates contain id : " + counter);

		idList.clear();
		idSet.clear();
		ex02.longAdder.reset();
		counter = 0;
		pool = Executors.newCachedThreadPool();
		for (int th = 0; th < threads; th++) {
			pool.submit(() -> {
				for (int i = 0; i < limit; i++) {
					idList.add(ex02.generateIdBySync());
				}
			});
		}

		pool.shutdown();
		pool.awaitTermination(10, TimeUnit.MINUTES);

		idList.stream().sequential().forEach(id -> {
			if (idSet.add(id) == false) {
				counter++;
			}
		});
		System.out.println("generateIdBySync() generates contain id : " + counter);
	}
}
