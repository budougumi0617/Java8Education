/**
 * @file
 * @par File Name:
 * Ex08.java
 * @author budougumi0617
 * @date Created on 2014/12/09
 */
package main.java.ch5.ex08;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note 現在の時刻インスタントに対してサポートされるすべてのタイムゾーンにおいて、
 *       今日の日付のオフセット（UTCとの差）を取得しなさい。
 *       その際、ZoneId.getAvailableIdsをストリームに変換してから、
 *       ストリーム操作を使用することによって取得しなさい。
 */
public class Ex08 {
	public static Stream<String> getZoneIdStream() {
		return ZoneId.getAvailableZoneIds().stream();
	}

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.of(2014, 12, 9, 20, 0);
		System.out.println("LocalDateTime : " + ldt.toString());
		getZoneIdStream().forEach(idString -> {
			ZonedDateTime zdt = ldt.atZone(ZoneId.of(idString));
			System.out.println(idString + " : Offset Time = " + zdt.getOffset().getId());
		});
	}
}
