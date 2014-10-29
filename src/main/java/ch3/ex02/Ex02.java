/**
 * @file
 * @par File Name:
 * Ex02.java
 * @author budougumi0617
 * @date Created on 2014/10/30
 */
package main.java.ch3.ex02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author budougumi0617
 * @note ReentrantLockを使用する場合には、次のイデオムでロックとアンロックをする必要があります。
 *       myLock.lock();
 *       try{
 *           //何らかの処理
 *       } finally {
 *           myLock.unlock();
 *       }
 *
 *       次のように呼び出すことができるwithLockメソッドを提供しなさい。
 *       withLock(myLock, () -> { /* 何らかの処理 * / } )
 *
 */
public interface Ex02 extends Runnable{

    static public void withLock(Lock myLock, Runnable runable){
        myLock.lock();
        try {
            runable.run();
        } finally{
            myLock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Ex02.withLock(lock, () -> {System.out.println("Test");});
    }

}
