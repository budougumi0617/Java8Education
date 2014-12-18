/**
 * @file
 * @par File Name:
 * Ex11.java
 * @author budougumi0617
 * @date Created on 2014/12/09
 */
package main.java.ch5.ex11;

import java.time.Duration;
import java.time.ZonedDateTime;

/**
 * @author budougumi0617
 * @note 帰りの便は、フランクフルトを14時5分に出発し、
 *       ロサンジェルスに16時40分に到着します。
 *       飛行時間は何時間何分ですか。このような計算を処理できるプログラムを書きなさい。
 */
public class Ex11 {
	public static Duration getFilightTimes(ZonedDateTime takeoff, ZonedDateTime arrive) {
		return Duration.between(takeoff.toLocalDateTime(), arrive.toLocalDateTime());
	}

	public static String getStringFlightTime(Duration d) {
		long hour = d.toHours();
		long minute = d.minusHours(hour).toMinutes();
		return String.format("%02d:%02d", hour, minute);
	}
}
