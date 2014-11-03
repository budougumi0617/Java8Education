/**
 * @file
 * @par File Name:
 * Ex03.java
 * @author budougumi0617
 * @date Created on 2014/11/04
 */
package main.java.ch3.ex03;

import java.util.function.BooleanSupplier;

/**
 * @author budougumi0617
 * @note Java
 *       1.4は、予約語AssertでもってJava言語にアサーションを追加しました。
 *       なぜ、アサーションは、ライブラリの機能として提供されてなかったのでしょう。
 *       Java8ではライブラリの機能として実装することができますか。
 * @note {@link http://docs.oracle.com/javase
 *       /jp/1.5.0/guide/language/assert.html}
 */
public class Ex03 {
	static private Boolean enableassertions = isEnableassertions();

	/**
	 * @return the enableassertions
	 */
	public static boolean isEnableassertions() {
		return enableassertions == null ? true : enableassertions;
	}

	/**
	 * @param enableassertions
	 *            the enableassertions to set
	 */
	public static void setEnableassertions(boolean enableassertions) {
		Ex03.enableassertions = enableassertions;
	}

	public static void assertByLambda(BooleanSupplier condition) {
		assertByLambda(condition, "");
	}

	public static void assertByLambda(BooleanSupplier condition, String message) {
		if (isEnableassertions() && condition.getAsBoolean())
			throw new AssertionError(message);
	}

	public static void main(String[] args) {
		System.out.println("Assert switch : " + Ex03.isEnableassertions());
		Ex03.assertByLambda(() -> false, "No assert");
		Ex03.setEnableassertions(false);
		System.out.println("Assert switch : " + Ex03.isEnableassertions());
		Ex03.assertByLambda(() -> true, "No assert");
		// Ex03.setEnableassertions(true);
		// Ex03.assertByLambda(() -> true,
		// "Throw AssertError");
	}

}
