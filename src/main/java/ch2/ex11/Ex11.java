/**
 * @file
 * @par File Name:
 * Ex11.java
 * @author budougumi0617
 * @date Created on 2014/10/22
 */
package main.java.ch2.ex11;

import java.util.ArrayList;
import java.util.stream.Stream;

import main.java.util.StreamOperating;

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stream<ArrayList<Integer>> stream = StreamOperating
				.createIntArraysListStream();

	}

}
