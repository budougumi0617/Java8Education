/**
 * @file
 * @par File Name:
 * StaticI.java
 * @author budougumi0617
 * @date Created on 2014/10/21
 */
package main.java.ch1.ex11;

/**
 * @author budougumi0617
 * @note staticメソッドfを持つインタフェースI
 */
public interface StaticI {
    static void f(){
        System.out.println("Call f() from StaticI Class");
    }

}
