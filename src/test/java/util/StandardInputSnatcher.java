/**
 * @file
 * @par File Name:
 * StandardInputSnatcher.java
 * @author budougumi0617
 * @date Created on 2015/02/12
 */
package test.java.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author kencoba
 * @see http 
 *      ://d.hatena.ne.jp/kencoba/20120831/1346398388
 * @note 標準入力に対し、文字列入力を行う
 */
public class StandardInputSnatcher extends InputStream {

	private StringBuilder buffer = new StringBuilder();
	private static String crlf = System.getProperty("line.separator");

	/**
	 * 文字列を入力する。改行は自動的に行う
	 * 
	 * @param str
	 *            入力文字列
	 */
	public void inputln(String str) {
		buffer.append(str).append(crlf);
	}

	@Override
	public int read() throws IOException {
		if (buffer.length() == 0) {
			return -1;
		}
		int result = buffer.charAt(0);
		buffer.deleteCharAt(0);
		return result;
	}
}