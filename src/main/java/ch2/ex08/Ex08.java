/**
 * @file
 * @par File Name:
 * Ex08.java
 * @author budougumi0617
 * @date Created on 2014/10/09
 */
package main.java.ch2.ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note public static <T> Stream<T> zip(Stream<T> first, Stream<T>
 *       second)メソッドを作成しなさい。 そのメソッドは、 ストリームであるfirstとsecondから要素を交互に取り出し、
 *       どちらかのストリームから要素がなくなったら停止します。
 */
public class Ex08 {
    /**
    *
    * @param first
    * @param second
    * @return firstとsecondから交互に長さが短い方のストリームの数だけ要素を交互に取り出しストリームを作成する
    */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        //TODO Need refactoring
        Spliterator<T> firstSpliterator = first.spliterator();
        Spliterator<T> secondSpliterator = second.spliterator();
        if (firstSpliterator.getExactSizeIfKnown() == -1
                && secondSpliterator.getExactSizeIfKnown() == -1) {
            throw new IllegalArgumentException(
                    "Both streams are the infinite stream");
        }
        List<T> firstArray = new ArrayList<T>();
        List<T> secondArray = new ArrayList<T>();
        if (firstSpliterator.getExactSizeIfKnown() == -1) {
            for (int i = 0; i < secondSpliterator.estimateSize(); i++)
                firstSpliterator.tryAdvance(x -> firstArray.add(x));
        } else {
            firstSpliterator.forEachRemaining(x -> firstArray.add(x));
        }
        firstArray.forEach(line -> System.out.println(line));
        if (secondSpliterator.getExactSizeIfKnown() == -1) {
            for (int i = 0; i < firstArray.size(); i++)
                secondSpliterator.tryAdvance(x -> secondArray.add(x));
        } else {
            secondSpliterator.forEachRemaining(x -> secondArray.add(x));
        }
        secondArray.forEach(line -> System.out.println(line));

        List<T> list = new ArrayList<T>();
        for (int i = 0; i < Math.min(firstArray.size(), secondArray.size()); i++) {
            list.add(firstArray.get(i));
            list.add(secondArray.get(i));
        }
        return list.stream();
    }

    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("1", "2", "3", "4");
        Stream<String> stream2 = Stream.of("one", "two", "three");
        Stream<String> mixed = zip(stream1, stream2);
        mixed.forEach(line -> System.out.println(line));
    }

}
