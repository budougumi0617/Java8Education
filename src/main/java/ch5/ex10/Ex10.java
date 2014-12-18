/**
 * @file
 * @par File Name:
 * Ex10.java
 * @author budougumi0617
 * @date Created on 2014/12/09
 */
package main.java.ch5.ex10;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author budougumi0617
 * @note ロサンジェルスからフランクフルト行きの便は、
 *       ローカル時刻の3時5分に出発し、10時間50分の飛行です。
 *       何時に到着しますか。このような計算を処理できるプログラムを書きなさい。
 */
public class Ex10 {
	public static LocalDateTime addFlightTime(LocalDateTime takeoffTime, long hours,
			long minutes) {
		return takeoffTime.plusHours(hours).plusMinutes(minutes);
	}

	public static ZonedDateTime getArrivalTimeWithZone(LocalDateTime localTime,
			ZoneId zoneId) {
		return localTime.atZone(zoneId);
	}

	public static LocalDateTime getTakeoffTimeWithoutZone(ZonedDateTime takeoffTime) {
		return takeoffTime.toLocalDateTime();
	}

	public static ZonedDateTime getArrivalTime(ZonedDateTime takeoffTime, long hours,
			long minutes, ZoneId zoneId) {
		return getArrivalTimeWithZone(
				addFlightTime(getTakeoffTimeWithoutZone(takeoffTime), hours, minutes),
				zoneId);
	}
}
