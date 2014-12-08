/**
 * @file
 * @par File Name:
 * Ex04.java
 * @author budougumi0617
 * @date Created on 2014/12/08
 */
package main.java.ch5.ex05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author budougumi0617
 * @note 今までに、あなたが生きてきた日数を表示するプログラムを書きなさい。
 */
public class Ex05 {

	public static long showNumberOfDaysIHaveLived() {
		return computeBetweenDays(LocalDate.of(1986, 6, 17), LocalDate.now());
	}

	private static long computeBetweenDays(LocalDate birthDay, LocalDate today) {
		return birthDay.until(today, ChronoUnit.DAYS);
	}

	public static void main(String[] args) {
		System.out.println("result " + showNumberOfDaysIHaveLived() + " days");
	}
}
