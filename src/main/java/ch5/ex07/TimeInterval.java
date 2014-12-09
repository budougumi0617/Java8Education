/**
 * @file
 * @par File Name:
 * TimeInterval.java
 * @author budougumi0617
 * @date Created on 2014/12/09
 */
package main.java.ch5.ex07;

import java.time.LocalDateTime;

/**
 * @author budougumi0617
 * @note （指定された日付の午前10時から午前11時といった）
 *       カレンダーイベントに適した、時刻のインターバルを表す
 *       TimeIntervalクラスを実装しなさい。２つのインターバルが
 *       重なっているかを検査するメソッドを提供しなさい。
 */
public class TimeInterval {
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public TimeInterval(LocalDateTime startTime, LocalDateTime endTime) {
		if (startTime.isAfter(endTime) || startTime.isEqual(endTime)) {
			throw new IllegalArgumentException("StartTime must earlier than endTime");
		}
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * @note ２つのインターバルが重なっているかを検査するメソッド
	 */
	public boolean duplicated(TimeInterval t) {
		boolean result = false;
		if (t.startTime.isAfter(this.endTime) || this.startTime.isAfter(t.endTime)) {
			result = false;
		} else if (this.startTime.isBefore(t.endTime)
				|| t.startTime.isBefore(this.endTime)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * @return the startTime
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public LocalDateTime getEndTime() {
		return endTime;
	}

}
