/**
 * @file
 * @par File Name:
 * Ex06.java
 * @author budougumi0617
 * @date Created on 2014/10/02
 */
package main.java.ch2.ex06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note 29ページの2.3節「filter, map,
 *       flatmapメソッド」のcharacterStreamメソッドは、
 *       最初にArrayListを埋めて、それからそのリストを
 *       ストリームに変換するといいう具合に、多少ぎこちないです。
 *       代わりに、ストリームを使用して、１行で書きなさい。
 *       適切な方法は、0からs.length() - 1までの
 *       整数のストリームを生成して、
 *       それをs::charAtメソッド参照でマップすることです。
 */
public class Ex06 {
	public static Stream<Character> characterStream(String s){
		List<Character> result = new ArrayList<>();
		for (char c : s.toCharArray()){
			result.add(c);
		}
		return result.stream();
	}
	public static Stream<Character> characterStreamByCharAt(String s){
		return Stream.iterate(0, n -> ++n).limit(s.length()).map(s::charAt);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputString = "testinputstrings";
		//Ex06.characterStream(inputString).forEach(System.out::println);
		
		System.out.println(Arrays.toString(Ex06.characterStream(inputString).toArray()));
		System.out.println(Arrays.toString(Ex06.characterStreamByCharAt(inputString).toArray()));
	}

}
