/**
 * @file
 * @par File Name:
 * Ex09.java
 * @author budougumi0617
 * @date Created on 2015/03/31
 */
package main.java.ch8.ex09;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author budougumi0617
 * @note Scannerを単語、行、整数、あるいは、
 *       double値のストリームへ変換するメソッドを書きなさい。
 *       ヒント：BufferedReader.linesのソースコードを調べなさい。
 */
public class Ex09 {

	public static Stream<String> lines(Scanner s) {
		s.useDelimiter("$");
		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(s, Spliterator.ORDERED
						| Spliterator.NONNULL), false);
	}

	public static Stream<String> words(Scanner s) {
		s.useDelimiter("[\\P{L}]+");
		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(s, Spliterator.ORDERED
						| Spliterator.NONNULL), false);
	}

	public static Stream<Integer> integers(Scanner s) {
		Iterator<Integer> iter = new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				return s.hasNextInt();
			}

			@Override
			public Integer next() {
				return s.nextInt();
			}
		};
		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED
						| Spliterator.NONNULL), false);
	}

	public static Stream<Double> doubles(Scanner s) {
		Iterator<Double> iter = new Iterator<Double>() {

			@Override
			public boolean hasNext() {
				return s.hasNextDouble();
			}

			@Override
			public Double next() {
				return s.nextDouble();
			}
		};
		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED
						| Spliterator.NONNULL), false);
	}

	public static void main(String[] args) {
		try (Scanner s = new Scanner(Paths.get("./src/main/resources/ch8/wordsFile.txt"))) {
			// lines(s).forEach(System.out::println);
			words(s).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (Scanner s = new Scanner(Paths.get("./src/main/resources/ch8/intFile.txt"))) {
			// lines(s).forEach(System.out::println);
			integers(s).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (Scanner s = new Scanner(Paths.get("./src/main/resources/ch8/doubleFile.txt"))) {
			// lines(s).forEach(System.out::println);
			doubles(s).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
