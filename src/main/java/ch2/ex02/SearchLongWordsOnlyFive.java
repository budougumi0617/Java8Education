/**
 * @file
 * @par File Name:
 * SearchLongWordsOnlyFive.java
 * @author budougumi0617
 * @date Created on 2014/10/02
 */
package main.java.ch2.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


/**
 * @author budougumi0617
 * @note 
 *       ある文字数以上の長い単語のうち最初の5個だけが求める処理において、5番目の長い単語がいったん
 *       みつかったら、filterメソッドが呼び出されないことを検証しなさい。単純に、
 *       各メソッドの呼び出しで、ログを出せば良いです。
 */
public class SearchLongWordsOnlyFive {
	
	List<String> words;
	static final int longLength = 12;
	
	public List<String> getWordsList() throws IOException {
		String contents = new String(Files.readAllBytes(
				Paths.get("./src/main/resources/ch2/alice.txt")), StandardCharsets.UTF_8);
		return (List<String>) Arrays.asList(contents.split("[\\P{L}]+"));
		
	}
	
	public int countLongWordBySingle(List<String> words){
		int count = 0;
		for (String w : words){
			if (w.length() > longLength) count++;
		}
		return count;
	}

	public int countLongWordByParallel(List<String> words){
		int count = 0;
		
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchLongWordsOnlyFive slwof = new SearchLongWordsOnlyFive();
		try {
			slwof.words = slwof.getWordsList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Count Result = " + slwof.countLongWordBySingle(slwof.words));
	}

}
