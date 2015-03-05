/**
 * @file
 * @par File Name:
 * Ex01.java
 * @author budougumi0617
 * @date Created on 2015/03/05
 */
package main.java.ch9.ex01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex01 {
	public static void readWordsFromFile(String inFile, String outFile) {
		try (Scanner in = new Scanner(Paths.get(inFile));
				PrintWriter out = new PrintWriter(outFile)) {
			while (in.hasNext())
				out.println(in.next().toLowerCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printToFile(Scanner in, String outFile)
			throws FileNotFoundException {
		PrintWriter out = new PrintWriter(outFile);
		try {
			while (in.hasNext())
				out.println(in.next().toLowerCase());
		} finally {
			try {
				out.close();
			} catch (Exception e) {
				// out.close()は例外をスローする。
				e.printStackTrace();
			}
		}
	}

	public static void readWordsFromFileVerJava6(String inFile, String outFile) {

		try {
			Scanner in = new Scanner(Paths.get(inFile));

			try {
				printToFile(in, outFile);
			} catch (FileNotFoundException e) {
				// PrintWriterのコンストラクタは例外をスローする。
				e.printStackTrace();
			} finally {
				try {

					in.close();
				} catch (Exception e) {
					// in.close()は例外をスローする。
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			// Scannerのコンストラクタは例外をスローする。
			e1.printStackTrace();
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
