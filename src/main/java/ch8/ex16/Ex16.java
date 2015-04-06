/**
 * @file
 * @par File Name:
 * Ex16.java
 * @author budougumi0617
 * @date Created on 2015/04/06
 */
package main.java.ch8.ex16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex16 {
	static final String CITY = "city";
	static final String STATE = "state";
	static final String ZIPCODE = "zipcode";
	static final Pattern pattern = Pattern.compile(".*\\s(?<" + CITY
			+ ">[\\p{L} ]+),\\s*(?<" + STATE + ">[A-Z]{2})\\s*(?<" + ZIPCODE
			+ ">[0-9]{5}|[0-9]{9})\\s.*");

	public static boolean isAddress(String line) {
		boolean result = false;
		Matcher matcher = pattern.matcher(line);
		if (matcher.matches()) {
			System.out.println("city = " + matcher.group(CITY) + "\nstate = "
					+ matcher.group(STATE) + "\nzipcode = " + matcher.group(ZIPCODE));
			result = true;
		}
		return result;
	}

	public static void main(String[] args) {
		try (Stream<String> lines = Files.lines(Paths
				.get("./src/main/resources/ch8/wordsFile.txt"))) {
			lines.filter(Ex16::isAddress).forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
