/**
 * @file
 * @par File Name:
 * Ex10Test.java
 * @author budougumi0617
 * @date Created on 2014/12/19
 */
package test.java.ch5.ex10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import main.java.ch5.ex10.Ex10;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Ex10Test {

	@Test
	public void testSameZone() {
		ZonedDateTime takeoffTime = ZonedDateTime.of(2014, 12, 19, 10, 0, 0, 0,
				ZoneId.of("Asia/Tokyo"));
		ZonedDateTime result = Ex10.getArrivalTime(takeoffTime, 10, 50,
				ZoneId.of("Asia/Tokyo"));
		assertThat(result.getHour(), is(20));
		assertThat(result.getMinute(), is(50));

	}

}
