/**
 * @file
 * @par File Name:
 * Ex02.java
 * @author budougumi0617
 * @date Created on 2015/03/05
 */
package main.java.ch9.ex02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author budougumi0617
 * @note 練習問題1を改善して、in.close()やout.close()
 *       によりスローされる例外を抑制された例外として、
 *       元々の例外へ追加するようにしなさい。
 */
public class Ex02 {
	public static void printToFile(Scanner in, String outFile) {
		Exception secondaryException = null;
		PrintWriter out = null;
		try {
			out = new PrintWriter(outFile);
			while (in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} catch (FileNotFoundException // PrintWriterのコンストラクタは例外をスローする。
				| IllegalStateException | NoSuchElementException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
				// out.close()は例外をスローする。
				if (secondaryException != null) {
					e.addSuppressed(secondaryException);
				}
				e.printStackTrace();
			}
		}
	}

	public static void readWordsFromFileVerJava6(String inFile, String outFile) {

		Exception secondaryException = null;
		Scanner in = null;
		try {
			in = new Scanner(Paths.get(inFile));
			printToFile(in, outFile);
		} catch (IOException ioe) {
			secondaryException = ioe;
			ioe.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				if (secondaryException != null) {
					e.addSuppressed(secondaryException);
				}
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String inFile = "./src/main/resources/ch2/alice.txt";
		String outFile = "tmp.txt";
		readWordsFromFileVerJava6(inFile, outFile);
		Path path = Paths.get(outFile);
		try {
			List<String> lines = Files.readAllLines(path);
			lines.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
