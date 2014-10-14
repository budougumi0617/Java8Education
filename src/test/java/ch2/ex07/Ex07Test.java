/**
 * @file
 * @par File Name:
 * Ex07Test.java
 * @author budougumi0617
 * @date Created on 2014/10/09
 */
package test.java.ch2.ex07;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import main.java.ch2.ex07.Ex07;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note 無限ストリームと有限ストリームをisFinite()に与えてみる。
 */
public class Ex07Test {

    @Test
    public void testGetTrue() {
        Stream<String> infiniteStream = Stream.generate(() -> "test");
        assertFalse(Ex07.isFinite(infiniteStream));
    }

    @Test
    public void testGetFalse() {
        Stream<String> finiteStream = Stream.generate(() -> "test").limit(10);
        assertTrue(Ex07.isFinite(finiteStream));
    }

}
