/**
 * @file
 * @par File Name:
 * Ex07.java
 * @author budougumi0617
 * @date Created on 2014/10/18
 */
package main.java.ch1.ex07;

/**
 * @author budougumi0617
 * @note 2つのRunnableインスタンスをパラメータとして受け取り、
 *       最初のRunnableを実行した後、2つ目のRunnableを実行する
 *       Runnableを返すように
 *       、staticメソッドandThenメソッドを書きなさい
 *       。mainメソッドでは、andThenへの呼び出しに
 *       2つのラムダ式を渡して、返されたインスタンスを実行しなさい。
 */
public class Ex07 {

	public static Runnable andThen(Runnable first, Runnable second) {
		Runnable doubleRun = () -> {
			first.run();
			second.run();
		};
		return doubleRun;
	}

	public static void main(String[] args) {
		Runnable doubleRun = Ex07.andThen(() -> {
			System.out.println("Start first thread");
		}, () -> {
			System.out.println("Start second thread");
		});
		Thread thread = new Thread(doubleRun);
		thread.start();
	}

}
