/**
 * @file
 * @par File Name:
 * DefaultI.java
 * @author budougumi0617
 * @date Created on 2014/10/21
 */
package main.java.ch1.ex11;

/**
 * @author budougumi0617
 * @note デフォルトメソッドfを持つインタフェースI
 */
public interface DefaultI {

    default void f() {
        System.out.println("Call f() from DefaultI Class");
    };
}
