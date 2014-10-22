/**
 * @file
 * @par File Name:
 * Ex11.java
 * @author budougumi0617
 * @date Created on 2014/10/22
 */
package main.java.ch2.ex11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note 単一のArrayListがストリームの大きさと同じ大きさで
 *       生成されている場合、複数のArrayListをマージすることなく、
 *       その単一のArrayListにストリームの結果を平行して収集できるはずです。
 *       なぜなら、互いに異なる位置へ平行して行うset操作であれば、
 *       スレッドセーフとなるからです。
 *       みなさんは、この収集をどうやって達成することができますか。
 */
public class Ex11 {
	static final int ARRAY_LIST_LENGTH = 100;

	public static Stream<Integer> createIntegerStream(int size) {
		return Stream.iterate(0, f -> ++f).limit(size);

	}

	public static <T> ArrayList<T> createArrayListByStream(Stream<T> stream,
			int size) {
		ArrayList<T> result = new ArrayList<T>(size);
		AtomicInteger index = new AtomicInteger();
		// TODO indexOutOfExceptionの場合有
		stream.parallel().forEach(x -> result.add(index.getAndIncrement(), x));
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> result = Ex11.createArrayListByStream(
				Ex11.createIntegerStream(ARRAY_LIST_LENGTH), ARRAY_LIST_LENGTH);
		result.stream().forEach(x -> {
			System.out.printf(" %d", x);
		});

	}
}
