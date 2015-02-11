/**
 * @file
 * @par File Name:
 * Ex10.java
 * @author budougumi0617
 * @date Created on 2015/02/05
 */
package main.java.ch6.ex10;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author budougumi0617
 * @note Please refer to README.md
 *       ユーザーにURLを問い合わせて、そのURLのウェブページを読み込み、
 *       全てのリンクを表示するプログラムを作成しなさい。
 *       各ステップに対して、CompletableFutureを使用しなさい
 *       。getを呼び出さないこと
 *       。プログラムの処理が終わる前に終了しないようにするために、
 *       次の呼び出しを行いなさい。
 */
public class Ex10 {
	private static InputStream in = System.in;
	private static final Pattern ptn = Pattern.compile("<a href=\"([^\"]+)\">",
			Pattern.DOTALL);

	public static List<String> getLinks(String page) {
		Matcher matcher = ptn.matcher(page);
		List<String> list = new ArrayList<String>();

		while (matcher.find()) {

			list.add(matcher.group(1));

		}
		return list;
	}

	public static String readPage(URL url) {
		StringBuilder builder = new StringBuilder();

		try (Scanner s = new Scanner(url.openStream())) {

			while (s.hasNextLine()) {
				builder.append(s.nextLine());
				builder.append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.toString();

	}

	public static String getPrompt() {
		System.out.println("Input url:");
		String spec = null;

		try (Scanner scan = new Scanner(in)) {
			spec = scan.next("^http://.*");
			System.out.println("Input string: " + spec);

		} catch (InputMismatchException e) {
			System.out.println("Input format : http://example.com");
		}
		return spec;
	}

	public static CompletableFuture<URL> getURLInput(String prompt) {
		return CompletableFuture.supplyAsync(() -> {
			URL url = null;
			try {
				url = new URL(prompt);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return url;
		});
	}

	static void ex10() {
		getURLInput("http://www.alc.co.jp/").thenApply(Ex10::readPage)
				.thenApply(p -> getLinks(p))
				.thenAccept(list -> list.stream().forEach(System.out::println));// System.out::println);
		ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
	}

	public static void main(String args[]) {
		ex10();
	}
}
