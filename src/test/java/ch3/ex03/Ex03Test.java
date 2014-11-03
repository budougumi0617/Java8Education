/**
 * @file
 * @par File Name:
 * Ex03Test.java
 * @author budougumi0617
 * @date Created on 2014/11/04
 */
package test.java.ch3.ex03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import main.java.ch3.ex03.Ex03;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author budougumi0617
 * @note ランタイムコストなしに実装されているか検証
 */
public class Ex03Test {
    private ByteArrayOutputStream _baos;
    private PrintStream _out;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        _baos = new ByteArrayOutputStream();
        _out = System.out;
        System.setOut(new PrintStream(new BufferedOutputStream(_baos)));
        // thrown = ExpectedException.none();
    }

    @After
    public void tearDown() {
        System.setOut(_out);
        Ex03.setEnableassertions(true);
    }

    @Test
    public void testDefaultNoAssert() {
        Ex03.assertByLambda(() -> true, "No assert");
        System.out.flush();
        String actual = _baos.toString();
        assertThat(actual, is(""));
    }

    @Test(expected = AssertionError.class)
    public void testDefaultAssertWithErrorMessage() {

        String resultString = "Throw AssertError";
        // thrown.expect(AssertionError.class);
        // thrown.expectMessage(resultString);
        Ex03.assertByLambda(() -> false, resultString);
    }
    @Test(expected = AssertionError.class)
    public void testDefaultAssert() {
        Ex03.assertByLambda(() -> false);
    }

    @Test
    public void testNoRuntimeCostWithErrorMessage() {
        Ex03.setEnableassertions(false);
        Ex03.assertByLambda(() -> {
            fail("We have RuntimeCost");
            return false;
        }, "No assert");
        System.out.flush();
        String actual = _baos.toString();
        assertThat(actual, is(""));
    }
    @Test
    public void testNoRuntimeCost() {
        Ex03.setEnableassertions(false);
        Ex03.assertByLambda(() -> {
            fail("We have RuntimeCost");
            return false;
        }, "No assert");
        System.out.flush();
        String actual = _baos.toString();
        assertThat(actual, is(""));
    }
}
