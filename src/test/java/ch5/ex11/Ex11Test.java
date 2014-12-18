/**
 * @file
 * @par File Name:
 * Ex11Test.java
 * @author budougumi0617
 * @date Created on 2014/12/09
 */
package test.java.ch5.ex11;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import main.java.ch5.ex11.Ex11;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Ex11Test {

	@Test
	public void testConvertString() {
		long hour = 10;
		long minute = 1;
		Duration d = Duration.ofHours(hour);
		d = d.plusMinutes(minute);
		assertThat(Ex11.getStringFlightTime(d), is("10:01"));
	}

	@Test
	public void testFlightTimeZero() {
		LocalDateTime ldt = LocalDateTime.now();
		ZonedDateTime takeoff = ldt.atZone(ZoneId.of("Asia/Singapore"));
		ZonedDateTime arrive = ldt.atZone(ZoneId.of("Asia/Tokyo"));
		assertThat(Ex11.getFilightTimes(takeoff, arrive).getSeconds(), is(0L));
	}

	@Test
	public void testFlightTimeFive() {
		ZonedDateTime takeoff = ZonedDateTime.of(2014, 12, 19, 10, 0, 0, 0,
				ZoneId.of("Asia/Tokyo"));
		System.out.println(takeoff);
		ZonedDateTime arrive = ZonedDateTime.of(2014, 12, 19, 15, 0, 0, 0,
				ZoneId.of("America/Los_Angeles"));
		assertThat(Ex11.getFilightTimes(takeoff, arrive).toHours(), is(5L));
	}
}
