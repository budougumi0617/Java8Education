/**
 * @file
 * @par File Name:
 * ImplementUnCheckMethod.java
 * @author budougumi0617
 * @date Created on 2014/09/16
 */
package main.java.ch1.ex06;

/**
 * @author budougumi0617
 * @note Runnable内でチェックされる例外を全て処理しなければならないことが、
 *       いつも面倒だと思っていませんか。チェックされる全ての例外をキャッチし、
 *       それがチェックされない例外へ変えるuncheckメソッドを書きなさい。
 *       たとえば、次のように使用します。 new Thread(uncheck(() ->
 *       { System.out.println("Zzz");
 *       Thread.sleep(1000); })).start();
 *
 *       どのような例外でもスローできるrunメソッドを持つRunnableExインターフェースを定義します
 *       。 そして、public static Runnable
 *       uncheck(RunnableEx runner)を実装します。
 *       uncheck関数内でラムダ式を使用します
 *       。なぜ、RunnableExの代わりにCallable
 *       <void>を使用できないのでしょうか。
 */
public class ImplementUnCheckMethod {
	@FunctionalInterface
	public interface RunnableEx {
		
		/** 
		 * @see java.lang.Runnable#run()
		 */
		public abstract void run() throws Exception;

	}
	
	public static Runnable uncheck(RunnableEx runner) {
		Runnable returnRunable = () -> {
			try {
				runner.run();
			} catch (Exception e) {
				 new RuntimeException(e);
			}
		};
		return returnRunable;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(uncheck(() -> {
			Thread.sleep(3_000);
			System.out.println("Zzz");
		})).start();

	}

}
