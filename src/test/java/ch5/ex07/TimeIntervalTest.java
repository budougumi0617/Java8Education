/**
 * @file
 * @par File Name:
 * TimeIntervalTest.java
 * @author budougumi0617
 * @date Created on 2014/12/09
 */
package test.java.ch5.ex07;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;

import main.java.ch5.ex07.TimeInterval;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author budougumi0617
 * @note タイムインターバルが重複しているか各条件でテストする。
 */
public class TimeIntervalTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * @note Not duplicated.
	 *       "ti1  between from 2014/12/09 20:00 to 2014/12/09 20:19"
	 *       "ti2  between from 2014/12/09 20:20 to 2014/12/09 20:30"
	 */
	@Test
	public void testNotDuplicated() {
		TimeInterval ti1 = new TimeInterval(LocalDateTime.of(2014, 12, 9, 20, 0),
				LocalDateTime.of(2014, 12, 9, 20, 19));
		TimeInterval ti2 = new TimeInterval(LocalDateTime.of(2014, 12, 9, 20, 20),
				LocalDateTime.of(2014, 12, 9, 20, 30));
		assertFalse(ti1.duplicated(ti2));
	}

	/**
	 * @note Not duplicated.
	 *       "ti1  between from 2014/12/09 20:11 to 2014/12/09 20:20"
	 *       "ti2  between from 2014/12/09 20:00 to 2014/12/09 20:10"
	 */
	@Test
	public void testNotDuplicated2() {
		TimeInterval ti1 = new TimeInterval(LocalDateTime.of(2014, 12, 9, 20, 11),
				LocalDateTime.of(2014, 12, 9, 20, 20));
		TimeInterval ti2 = new TimeInterval(LocalDateTime.of(2014, 12, 9, 20, 0),
				LocalDateTime.of(2014, 12, 9, 20, 10));
		assertFalse(ti1.duplicated(ti2));
	}

	/**
	 * @note Not duplicated.
	 *       "ti1  between from 2014/12/09 20:10 to 2014/12/09 20:30"
	 *       "ti2  between from 2014/12/09 20:00 to 2014/12/09 20:20"
	 */
	@Test
	public void testDuplicated() {
		TimeInterval ti1 = new TimeInterval(LocalDateTime.of(2014, 12, 9, 20, 10),
				LocalDateTime.of(2014, 12, 9, 20, 30));
		TimeInterval ti2 = new TimeInterval(LocalDateTime.of(2014, 12, 9, 20, 0),
				LocalDateTime.of(2014, 12, 9, 20, 20));
		assertTrue(ti1.duplicated(ti2));
	}

	/**
	 * @note Not duplicated.
	 *       "ti1  between from 2014/12/09 20:00 to 2014/12/09 20:10"
	 *       "ti2  between from 2014/12/09 20:05 to 2014/12/09 20:30"
	 */
	@Test
	public void testDuplicated2() {
		TimeInterval ti1 = new TimeInterval(LocalDateTime.of(2014, 12, 9, 20, 0),
				LocalDateTime.of(2014, 12, 9, 20, 10));
		TimeInterval ti2 = new TimeInterval(LocalDateTime.of(2014, 12, 9, 20, 5),
				LocalDateTime.of(2014, 12, 9, 20, 30));
		assertTrue(ti1.duplicated(ti2));
	}

	/**
	 * @note Not duplicated.
	 *       "ti1  between from 2014/12/08 20:00 to 2014/12/20 20:30"
	 *       "ti2  between from 2014/12/09 20:00 to 2014/12/09 20:20"
	 */
	@Test
	public void testDuplicated3() {
		TimeInterval ti1 = new TimeInterval(LocalDateTime.of(2014, 12, 8, 20, 0),
				LocalDateTime.of(2014, 12, 20, 20, 30));
		TimeInterval ti2 = new TimeInterval(LocalDateTime.of(2014, 12, 9, 20, 0),
				LocalDateTime.of(2014, 12, 9, 20, 20));
		assertTrue(ti1.duplicated(ti2));
	}

	/**
	 * @note Not duplicated.
	 *       "ti1  between from 2014/12/09 09:00 to 2014/12/09 10:00"
	 *       "ti2  between from 2014/12/04 20:00 to 2014/12/30 20:20"
	 */
	@Test
	public void testDuplicated4() {
		TimeInterval ti1 = new TimeInterval(LocalDateTime.of(2014, 12, 9, 9, 0),
				LocalDateTime.of(2014, 12, 9, 10, 0));
		TimeInterval ti2 = new TimeInterval(LocalDateTime.of(2014, 12, 4, 20, 0),
				LocalDateTime.of(2014, 12, 30, 20, 20));
		assertTrue(ti1.duplicated(ti2));
	}

	@Test
	public void testConstructer() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("StartTime must earlier than endTime");

		new TimeInterval(LocalDateTime.of(2014, 12, 9, 20, 0), LocalDateTime.of(2014, 12,
				9, 20, 0));
		fail();
	}

	@Test
	public void testConstructer2() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("StartTime must earlier than endTime");

		new TimeInterval(LocalDateTime.of(2014, 12, 9, 20, 0), LocalDateTime.of(2013, 12,
				9, 20, 0));
		fail();
	}
}
