/**
 * @file
 * @par File Name:
 * ExThread3.java
 * @author budougumi0617
 * @date Created on 2014/10/23
 */
package main.java.ch1.ex05;

/**
 * @author budougumi0617
 * @note 自分のプロジェクトの1つから、 AcrionListenerやRunnableといったインターフェースを多数使用している
 *       ファイルを1つ選んで下さい。それらのインタフェースの仕様をラムダ式に置き換えなさい。
 *       置き換えた結果、コードは何行短くなりましたか。コードは読みやすくなりましたか。 メソッド参照を使用することはできましたか。
 *       http://www.javaroad.jp/java_thread3.htm
 */
public class ExThread3 {

    private static class ShowName implements Runnable {
        // (2)runメソッドの本体を定義
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("名前：Java太郎");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private static class ShowFurigana implements Runnable {

        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("ふりがな：javaたろう");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        ShowName sn = new ShowName();

        ShowFurigana sf = new ShowFurigana();


        Thread thread1 = new Thread(sn);
        Thread thread2 = new Thread(sf);

        thread1.start(); // (9)スレッドを実行可能状態にする
        thread2.start(); // (10)スレッドを実行可能状態にする
    }
}
