/**
 * @file
 * @par File Name:
 * Ex08Test.java
 * @author budougumi0617
 * @date Created on 2014/11/11
 */
package test.java.ch2.ex08;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import main.java.ch2.ex08.Ex08;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author budougumi0617
 * @note zipの通常処理、無限ストリームを受け付けるか検証する
 */
public class Ex08Test {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testNormal() {
        Stream<String> stream1 = Stream.of("1", "2", "3", "4");
        Stream<String> stream2 = Stream.of("one", "two", "three");
        Stream<String> result = Ex08.zip(stream1, stream2);

        assertArrayEquals(
                new String[] { "1", "one", "2", "two", "3", "three" },
                result.toArray());
    }

    @Test
    public void testInsertInfiniteStream1() {
        System.out.println("testInsertInfiniteStream1()");
        Stream<Integer> stream1 = Stream.iterate(0, x -> x + 1);
        Stream<Integer> stream2 = Stream.of(10, 11, 12, 13, 14, 15);
        Stream<Integer> result = Ex08.zip(stream1, stream2);

        assertArrayEquals(new Integer[] { 0, 10, 1, 11, 2, 12, 3, 13, 4, 14, 5,
                15, }, result.toArray());
    }

    @Test
    public void testInsertInfiniteStream2() {
        System.out.println("testInsertInfiniteStream2()");
        Stream<Integer> stream1 = Stream.of(0, 1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.iterate(10, x -> x + 1);
        Stream<Integer> result = Ex08.zip(stream1, stream2);

        assertArrayEquals(new Integer[] { 0, 10, 1, 11, 2, 12, 3, 13, 4, 14, 5,
                15, }, result.toArray());
    }

    @Test
    public void testInsertInfiniteStreams() {
        Stream<Integer> stream1 = Stream.iterate(0, x -> x + 1);
        Stream<Integer> stream2 = Stream.iterate(10, x -> x + 1);
        String resultString = "Both streams are the infinite stream";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(resultString);

        Ex08.zip(stream1, stream2);

        fail();
    }
}
