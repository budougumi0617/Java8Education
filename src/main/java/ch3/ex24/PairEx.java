/**
 * @file
 * @par File Name:
 * Ex24.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package main.java.ch3.ex24;

import java.util.function.BiFunction;
import java.util.function.Function;

import main.java.ch3.ex23.Pair;

/**
 * @author budougumi0617
 * @note Pair<T>に対するflatMapメソッドを定義することができますか。
 *       できるとしたら、それは何ですか。できないとしたらその理由は何ですか。
 */
public class PairEx<T> extends Pair<T> {

	/**
	 * @param element1
	 * @param element2
	 */
	public PairEx(T element1, T element2) {
		super(element1, element2);
	}

	/**
	 * 指定されたPair生成マッピング関数を２つの要素に適用し、その結果を返します。
	 * 
	 * @param mapper
	 * @return
	 */
	@SuppressWarnings("unused")
	public <U> PairEx<U> flatMap(Function<? super T, PairEx<U>> mapper) {
		PairEx<U> element1Map = mapper.apply(this.element1);
		PairEx<U> element2Map = mapper.apply(this.element2);
		return null;
	}

	/**
	 * flatMapで行いたい操作ではない。
	 * 
	 * @param mapper
	 * @return
	 */
	public <U> PairEx<U> flatMapByBiFunction(
			BiFunction<? super T, ? super T, PairEx<U>> mapper) {
		return mapper.apply(this.element1, this.element2);
	}
}
