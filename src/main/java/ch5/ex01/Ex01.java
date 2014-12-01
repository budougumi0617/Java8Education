/**
 * @file
 * @par File Name:
 * Ex01.java
 * @author budougumi0617
 * @date Created on 2014/11/30
 */
package main.java.ch5.ex01;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author budougumi0617
 * @note plusDaysを使用しないで、プログラマーの日を計算しなさい。
 */
public class Ex01 {
	public static LocalDate getProgrammersDayByPlus(int year) {
		return LocalDate.of(year, 1, 1).plus(255, ChronoUnit.DAYS);
	}

	public static LocalDate getProgrammersDayByOfYearDay(int year) {
		return LocalDate.ofYearDay(year, 256);
	}

}
