/**
 * @file
 * @par File Name:
 * Ex06.java
 * @author budougumi0617
 * @date Created on 2014/12/08
 */
package main.java.ch5.ex06;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note 20世紀の全ての１３日の金曜日を列挙しなさい
 */
public class Ex06 {
	static final int NUMBER_OF_MONTHS_IN_CENTURY = 12 * 100;

	public static Stream<LocalDate> generateFridayThe13thStream() {
		return Stream.iterate(LocalDate.of(1901, 1, 13), day -> day.plusMonths(1))
				.limit(NUMBER_OF_MONTHS_IN_CENTURY)
				.filter(w -> w.getDayOfWeek().getValue() == 5)
				.filter(w -> w.getYear() <= 2000);
	}

	public static void main(String[] args) {
		generateFridayThe13thStream().forEach(
				w -> System.out.println(w + " " + w.getDayOfWeek()));
	}
}
