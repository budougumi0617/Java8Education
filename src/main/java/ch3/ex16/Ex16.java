/**
 * @file
 * @par File Name:
 * Ex16.java
 * @author budougumi0617
 * @date Created on 2014/11/21
 */
package main.java.ch3.ex16;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author budougumi0617
 * @note 71ページの3.8節「例外の取り扱い」のdoInOrderAsyncを実装し、
 * 2つ目のパラメータはBiConsumer<T,Throwalbe>としなさい。
 * うまいユースケースを示しなさい。
 * 3つ目のパラメータは必要ですか
 * ----
 * Answer
 * Supplier<T> firstからの例外をBiConsumer<T, Throwable> secondに処理させる。
 * secondが例外を処理するので、3つ目のパラメータConsumer<Throwable> handlerは不要。
 * ユースケースはWIP
 */
public class Ex16 {
    public static <T> void doIntOrdeaAsync(Supplier<T> first,
            BiConsumer<T, Throwable> second, Consumer<Throwable> handler) {
        Thread t = new Thread() {
            public void run() {
                T result = null;
                try {
                    result = first.get(); //Supplierから結果を取得
                } catch (Throwable t) {
                    second.accept(result, t); //
                }
            }
        };
        t.start();
    }
}
