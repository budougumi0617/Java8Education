/**
 * @file
 * @par File Name:
 * Ex11.java
 * @author budougumi0617
 * @date Created on 2015/01/25
 */
package main.java.ch6.ex11;

import java.net.PasswordAuthentication;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex11 {
	public static String CORRECT_PASSWORD = "secret";
	public static Scanner input = new Scanner(System.in);

	public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
		return CompletableFuture.supplyAsync(action).thenComposeAsync(
				t -> until.test(t) ? CompletableFuture.completedFuture(t) : repeat(
						action, until));
	}

	public static PasswordAuthentication getPasswordAuthentication() {
		System.out.print("Type Username : ");
		String user = input.nextLine();
		System.out.print("Type Password : ");
		String pass = input.nextLine();
		return new PasswordAuthentication(user, pass.toCharArray());
	}

	public static boolean validatePassword(PasswordAuthentication pa) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Arrays.equals(pa.getPassword(), CORRECT_PASSWORD.toCharArray());

	}

	public static void main(String[] args) {
		repeat(Ex11::getPasswordAuthentication, pa -> validatePassword(pa));
		ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
		System.out.println("End password varidation");
	}
}
