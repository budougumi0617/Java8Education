/**
 * @file
 * @par File Name:
 * Ex01.java
 * @author budougumi0617
 * @date Created on 2014/10/23
 */
package main.java.ch1.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author budougumi0617
 * @note Arrays.sortメソッド内で呼び出されるコンパレータのコードは、sortメソッドを
 *       呼び出したスレッドで実行されるでしょうか。それとも、別のスレッドで実行されるでしょうか
 *       --
 *       Answer
 *       Comparater thread name = main
 *       Main thread end
 *       Main thread name =  main
 *
 */
public class Ex01 {

    public static List<String> getWordsList() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("./src/main/resources/ch2/alice.txt")),
                StandardCharsets.UTF_8);
        return (List<String>) Arrays.asList(contents.split("[\\P{L}]+"));

    }

    public static void main(String[] args) {
        System.out.println("Main thread name =  "
                + Thread.currentThread().getName());
        String[] words = null;
        try {
            words = (String[]) getWordsList().toArray();
            Arrays.sort(
                    words,
                    (String first, String second) -> {
                        System.out.println("Comparater thread name = "
                                + Thread.currentThread().getName());
                        return Integer.compare(first.length(), second.length());
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread end");
        System.out.println("Main thread name =  "
                + Thread.currentThread().getName());
    }

}
