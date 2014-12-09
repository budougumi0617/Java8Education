/**
 * @file
 * @par File Name:
 * Ex09.java
 * @author budougumi0617
 * @date Created on 2014/12/09
 */
package main.java.ch5.ex09;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note 再度、ストリーム操作を使用して、
 *       オフセットに１時間未満の情報が含まれるすべてのタイムゾーンを見つけなさい。
 */
public class Ex09 {
	public static Stream<String> getFilteredZoneIdStream() {
		return ZoneId
				.getAvailableZoneIds()
				.stream()
				.filter(idName -> Math.abs(ZonedDateTime.now(ZoneId.of(idName))
						.getOffset().getTotalSeconds()) < 60 * 60);
	}

	public static void main(String[] args) {
		// TODO Need Test case
		LocalDateTime ldt = LocalDateTime.of(2014, 12, 9, 20, 0);
		System.out.println("LocalDateTime : " + ldt.toString());
		getFilteredZoneIdStream().forEach(
				idName -> {
					ZonedDateTime zdt = ldt.atZone(ZoneId.of(idName));
					System.out.println(idName + " : Offset Seconds = "
							+ zdt.getOffset().getTotalSeconds());
				});
	}
}
