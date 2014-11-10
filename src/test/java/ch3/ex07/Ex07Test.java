/**
 * @file
 * @par File Name:
 * Ex07Test.java
 * @author budougumi0617
 * @date Created on 2014/11/10
 */
package test.java.ch3.ex07;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Arrays;

import main.java.ch3.ex07.Ex07;

import org.junit.Before;
import org.junit.Test;

/**
 * @author budougumi0617
 * @note Ex07.generateStringComparatorの検証
 */
public class Ex07Test {
    String[] words;
    private boolean isReverse;
    private boolean isCaseInsensitive;
    private boolean unIncludeSpace;
    private final String[] inputString = { "00", "03", "0 1", "t3", "t0", "T2" };

    @Before
    public void setWords() {
        words = new String[inputString.length];
        for (int i = 0; i < words.length; i++) {
            words[i] = inputString[i];
        }
        isReverse = isCaseInsensitive = unIncludeSpace = false;
    }

    @Test
    public void testNatural() {
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        System.out.println(unIncludeSpace);
        Arrays.sort(words, Ex07.generateStringComparator(isReverse,
                isCaseInsensitive, unIncludeSpace));
        assertThat(words,
                is(new String[] { "0 1", "00", "03", "T2", "t0", "t3" }));
    }

    @Test
    public void testReverse() {
        isReverse = true;
        Arrays.sort(words, Ex07.generateStringComparator(isReverse,
                isCaseInsensitive, unIncludeSpace));
        assertThat(words,
                is(new String[] { "t3", "t0", "T2", "03", "00", "0 1" }));
    }

    @Test
    public void testUnIncludeSpace() {
        unIncludeSpace = true;
        Arrays.sort(words, Ex07.generateStringComparator(isReverse,
                isCaseInsensitive, unIncludeSpace));
        assertThat(words,
                is(new String[] { "00", "0 1", "03", "T2", "t0", "t3" }));
    }

    @Test
    public void testIgnoreCase() {
        isCaseInsensitive = true;
        Arrays.sort(words, Ex07.generateStringComparator(isReverse,
                isCaseInsensitive, unIncludeSpace));
        assertThat(words,
                is(new String[] { "0 1", "00", "03", "t0", "T2", "t3" }));
    }

    @Test
    public void testReverseUnIncludeSpace() {
        isReverse = isCaseInsensitive = true;
        Arrays.sort(words, Ex07.generateStringComparator(isReverse,
                isCaseInsensitive, unIncludeSpace));
        assertThat(words,
                is(new String[] { "t3", "t0", "T2", "03", "0 1", "00" }));
    }

    @Test
    public void testReverseIgnoreCase() {
        isReverse = isCaseInsensitive = true;
        Arrays.sort(words, Ex07.generateStringComparator(isReverse,
                isCaseInsensitive, unIncludeSpace));
        assertThat(words,
                is(new String[] { "t3", "T2", "t0", "03", "00", "0 1" }));
    }

    @Test
    public void testUnIncludeSapceIgnoreCase() {
        unIncludeSpace = isCaseInsensitive = true;
        Arrays.sort(words, Ex07.generateStringComparator(isReverse,
                isCaseInsensitive, unIncludeSpace));
        assertThat(words,
                is(new String[] { "00", "0 1", "03", "t0", "T2", "t3" }));
    }

    @Test
    public void testReverseIgnoreCaseUnIncludeSapce() {
        isReverse = isCaseInsensitive = unIncludeSpace = true;
        Arrays.sort(words, Ex07.generateStringComparator(isReverse,
                isCaseInsensitive, unIncludeSpace));
        assertThat(words,
                is(new String[] { "t3", "T2", "t0", "03", "0 1", "00" }));
    }
}
