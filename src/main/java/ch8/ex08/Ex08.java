/**
 * @file
 * @par File Name:
 * Ex8.java
 * @author budougumi0617
 * @date Created on 2015/04/04
 */
package main.java.ch8.ex08;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author budougumi0617
 * @note CheckQueueクラスの利点を示すプログラムを書きなさい。
 */
public class Ex08 {

	public static void main(String[] args) {
		Queue<Integer> integerQueue = Collections.checkedQueue(
				new PriorityQueue<Integer>(), Integer.class);
		try {
			addObject(integerQueue);
		} catch (ClassCastException e) {
			System.out.println("We can detect miss insert");
		}
		for (int i = 0; i < integerQueue.size(); i++) {
			System.out.println(integerQueue.poll());
		}
	}

	@SuppressWarnings("unchecked")
	public static void addObject(@SuppressWarnings("rawtypes") Queue q)
			throws ClassCastException {
		q.add(new Object());
	}
}
