/**
 * @file
 * @par File Name:
 * Ex3.java
 * @author budougumi0617
 * @date Created on 2014/12/08
 */
package main.java.ch5.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

/**
 * @author budougumi0617
 * @note Predicate<LocalDate>を受け取り、
 *       TemporalAdjusterを返すnextメソッドを実装しなさい。
 *       返されたTemporalAdjusterは、
 *       nextメソッドに渡された述語を満足する翌日の日付を生成します。
 *       たとえば、次のコードを見てください。
 *       "today.with(next( w -> w.getDayOfWeek().getValue() < 6))"
 *       このコードは、今日より後にあって平日となる最初の日付を返します。
 */
public class Ex03 {

	public static TemporalAdjuster next(Predicate<LocalDate> f) {
		return w -> {
			LocalDate result = (LocalDate) w;
			do {
				result = result.plusDays(1);
			} while (!f.test(result));
			return result;
		};
	}

	public static void main(String[] args) {
		System.out.println("Result");
		System.out.println("Result"
				+ LocalDate.of(2014, 12, 8).with(
						next(w -> w.getDayOfWeek().getValue() < 6)));
	}
}
