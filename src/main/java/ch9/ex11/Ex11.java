/**
 * @file
 * @par File Name:
 * Ex11.java
 * @author budougumi0617
 * @date Created on 2015/04/06
 */
package main.java.ch9.ex11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex11 {
	public static String USER_HOME = System.getenv("HOME");
	public static List<String> result = new ArrayList<String>();

	public static void executeGrep() {
		ProcessBuilder builder = new ProcessBuilder("grep", "-roh", "[0-9]\\{14,16\\} ",
				"./");
		builder.directory(Paths.get(USER_HOME).toFile());
		try {
			Process process = builder.start();
			process.waitFor();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getInputStream()))) {
				for (String line = br.readLine(); line != null; line = br.readLine()) {
					System.out.println(line);
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		USER_HOME = "./";
		Ex11.executeGrep();
		result.forEach(System.out::println);
	}
}
