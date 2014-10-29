/**
 * @file
 * @par File Name:
 * Ex03Test.java
 * @author budougumi0617
 * @date Created on 2014/10/30
 */
package test.java.ch3.ex02;

import static org.junit.Assert.*;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import main.java.ch3.ex02.Ex02;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note Lockが行われて実行されているかチェックする
 */
public class Ex02Test {

    @Test
    public void test() {
        Lock lock = new ReentrantLock();
        Ex02.withLock(lock, () -> {System.out.println("Test");});
        fail("まだ実装されていません");
    }

}
