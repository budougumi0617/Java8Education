/**
 * @file
 * @par File Name:
 * Ex10.java
 * @author budougumi0617
 * @date Created on 2014/10/22
 */
package main.java.ch2.ex10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note Stream<Double> の平均を計算するために
 *       使用できるreduceの呼び出しを書きなさい。
 *       単純に合計を計算して、count()で割ることができないのはなぜですか。
 * 
 *       ---
 * 
 *       Answer
 *       「合計を計算する=終端操作を行う」なので、count()は呼び出せない。
 *       （合計計算後にストリーム操作はもう行えない）
 */
public class Ex10 {

	static Stream<Double> createDoubleStream() {
		return Stream.iterate(0., x -> x + 1.).limit(20);
	}

	static Double getAverageDoubleStream(Stream<Double> doubleStream) {
		AtomicInteger counter = new AtomicInteger();
		return doubleStream.reduce(0., (x, y) -> {
			counter.incrementAndGet();
			return x + y;
		}) / counter.get();

	}

	public static void main(String[] args) {
		createDoubleStream().forEach(System.out::println);
		System.out.println("Average value : "
				+ getAverageDoubleStream(createDoubleStream()).toString());
	}
}
