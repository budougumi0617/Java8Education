/**
 * @file
 * @par File Name:
 * Ex06Test.java
 * @author budougumi0617
 * @date Created on 2014/10/02
 */
package test.java.ch2.ex06;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Stream;

import main.java.ch2.ex06.Ex06;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note P30のcharacterStream()と同じ結果が得られるかテストする。
 */
public class Ex06Test {
	
	private String getStringFromCharacterStream(Stream<Character> s){
		return Arrays.toString(s.toArray());
	}
	
	@Test
	public void checkSameResult() {
		String s = "Both methods will be same result";
		assertThat(getStringFromCharacterStream(Ex06.characterStreamByCharAt(s)),
				is(getStringFromCharacterStream(Ex06.characterStream(s))));
	}

}
