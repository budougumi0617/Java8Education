/**
 * @file
 * @par File Name:
 * Ex01Test.java
 * @author budougumi0617
 * @date Created on 2014/10/28
 */
package test.java.ch3.ex01;

import static org.junit.Assert.*;

import java.util.logging.Level;

import main.java.ch3.ex01.Ex01;

import org.junit.Before;
import org.junit.Test;

/**
 * @author budougumi0617
 * @note fail()を含んだラムダ式を渡すことで、条件式が判断されているかテストする。
 */
public class Ex01Test {

    @Before
    public void setLevel() {
        Ex01.setLoggerLevel(Level.INFO);
    }

    @Test
    public void testVerifyNotCallCondition() {
        Ex01.logIf(Level.FINEST, () -> {
            fail("BooleanSupplier must not be Called");
            return true;
        }, () -> "Not Log");
    }

    @Test
    public void testVerifyNotLog() {
        Ex01.logIf(Level.INFO, () -> false, () -> {
            fail("Supplier<String> must not be Called");
            return "Not Log";
        });
    }

    @Test
    public void testVerifyCallCondition() {
        String result = "Log OK";
        Ex01.logIf(Level.INFO, () -> true, () -> result);
    }
}
