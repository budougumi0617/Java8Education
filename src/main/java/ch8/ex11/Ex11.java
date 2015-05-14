/**
 * @file
 * @par File Name:
 * Ex11.java
 * @author budougumi0617
 * @date Created on 2015/05/14
 */
package main.java.ch8.ex11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex11 {

	public static void connectSecurityPage(String address) {

		try {
			URL url = new URL(address);
			URLConnection connection = url.openConnection();
			String authInfo = "username:p@ssw0rd";
			Base64.Encoder encoder = Base64.getEncoder();
			String encodedString = encoder.encodeToString(authInfo
					.getBytes(StandardCharsets.UTF_8));
			connection.setRequestProperty("Authorization", "Basic " + encodedString);
			connection.connect();
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println(sb.toString());
			br.close();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String address = "https://foo.com";
		Ex11.connectSecurityPage(address);
	}
}
