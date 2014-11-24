/**
 * @file
 * @par File Name:
 * Ex23.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package main.java.ch3.ex23;

import java.util.function.Function;

/**
 * @author budougumi0617
 * @note T型の対となる2つのオブジェクトを表す
 *       Pair<T>クラスに対するmap操作を定義しなさい。
 */
public class Pair<T> {
	public T element1;
	public T element2;

	public Pair(T element1, T element2) {
		this.element1 = element1;
		this.element2 = element2;
	}

	/**
	 * 指定されたマッピング関数を２つの要素に適用し、結果のPairを返します。
	 * 
	 * @param mapper
	 * @return
	 */
	public <U> Pair<U> map(Function<? super T, ? extends U> mapper) {
		return new Pair<U>(mapper.apply(this.element1), mapper.apply(this.element2));
	}
}
