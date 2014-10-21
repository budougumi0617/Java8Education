/**
 * @file
 * @par File Name:
 * DefaultJ.java
 * @author budougumi0617
 * @date Created on 2014/10/21
 */
package main.java.ch1.ex11;

/**
 * @author budougumi0617
 * @note デフォルトメソッドfを持つインタフェースJ
 */
public interface DefaultJ {

    default void f() {
        System.out.println("Call f() from DefaultJ Class");
    };
}
