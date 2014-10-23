/**
 * @file
 * @par File Name:
 * Ex05.java
 * @author budougumi0617
 * @date Created on 2014/10/23
 */
package main.java.ch2.ex05;

import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note Stream.iterateを使用して乱数の無限ストリームを生成しなさい。
 *       このときMath.randomを呼び出すのではなく、
 *       線形合同生成機(linear congruential generator)を 直接実装すること。
 *       そのような生成機では、x_0 = seedで
 *       初めてa, c, mの適切な値に対して、 x_(n+1) = (ax_n + c)%mを生成します。
 *       パラメータa, c, m, seedを受け取り、Stream<Long>を生成するメソッドを実装しなさい。
 *       a = 25212903917、c = 11、m = 2^48を試してみなさい。
 */
public class Ex05 {
    public static Stream<Long> executeLinearCongruentialGenerator(long a,
            long c, long m, long seed) {
        return Stream.iterate(seed, n -> (a * n + c) % m);
    }

    public static void main(String[] args) {
        executeLinearCongruentialGenerator(25214903917L, 11L,
                (long) Math.pow(2, 48), 1).limit(20).forEach(
                x -> System.out.println(x));
    }

}
