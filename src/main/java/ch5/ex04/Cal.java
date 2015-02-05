/**
 * @file
 * @par File Name:
 * Cal.java
 * @author budougumi0617
 * @date Created on 2015/02/05
 */
package main.java.ch5.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * @author budougumi0617
 * @note 
 *       ある月のカレンダーを表示するUnixのcalプログラムと同じプログラムを書きなさい。
 */
public class Cal {
	private static int month = 0;
	private static int year = 0;

	public static List<String> getMonthResult(int year, int month) {
		LocalDate date = LocalDate.of(year, month, 1);
		LinkedList<String> result = new LinkedList<String>();
		result.add("      " + date.getMonth().getDisplayName(TextStyle.SHORT, Locale.US)
				+ "   " + String.format("%4d", year) + "     ");
		result.add(" Mo Tu We Th Fr Sa Su");
		StringBuilder week = new StringBuilder();
		for (int i = 0; i < date.getDayOfWeek().getValue() - 1; i++) {
			week.append("   ");
		}
		while (date.getMonthValue() == month) {
			week.append(String.format("%1$3d", date.getDayOfMonth()));
			date = date.plusDays(1);
			if (date.getDayOfWeek() == DayOfWeek.MONDAY || date.getMonthValue() != month) {
				result.add(week.toString());
				week.delete(0, week.length());
			}
		}
		return result;
	}

	public static void simulateCal(String[] args) {
		parseArgment(args);
		List<String> list = Cal.getMonthResult(year, month);
		list.stream().sequential().forEach(System.out::println);

	}

	private static void usage() {
		System.err.println("Usage: cal [month year]");
		System.exit(0);
	}

	public static void parseArgment(String[] args) {

		switch (args.length) {
		case 0:
			LocalDate now = LocalDate.now();
			month = now.getMonthValue();
			year = now.getYear();
			break;
		case 2:
			month = Integer.parseInt(args[0]);
			year = Integer.parseInt(args[1]);
			break;
		default:
			usage();
		}

	}

	public static void main(String[] args) {
		// args = new String[] { "6", "2014" };
		Cal.simulateCal(args);
	}
}
