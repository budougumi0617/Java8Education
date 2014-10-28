/**
 * @file
 * @par File Name:
 * Ex01.java
 * @author budougumi0617
 * @date Created on 2014/10/28
 */
package main.java.ch3.ex01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author budougumi0617
 * @note 条件的なロギングを提供することで、遅延ロギング技法を強化しなさい。 典型的な呼び出しは、 logIf(Level.FINEST, () ->
 *       i == 10, () -> "a[10] = " + a[1]) となります。
 *       ロガーがメッセージをロギングしないのであれば、その条件を評価しないようにしなさい。 Loggerのレベルは降順で次のとおりです。 SEVERE
 *       (最高値), WARNING (警告), INFO, CONFIG, FINE, FINER, FINEST (最低値)
 * @see <a
 *      href="http://docs.oracle.com/javase/jp/8/api/java/util/function/package-frame.html">Supplier系</a>
 * @see test.java.ch3.ex01.Ex01Test
 */
public class Ex01 {
    static private Logger logger = Logger.getLogger(Ex01.class.getName());

    public static void setLoggerLevel(Level level) {
        Ex01.logger.setLevel(level);
    }

    public static void logIf(Level level, BooleanSupplier condition,
            Supplier<String> message) {
        System.out.println("Called Method");
        if (logger.isLoggable(level)) {
            System.out.println("Cheked Logging Level");
            if (condition.getAsBoolean()) {
                System.out.println("Cheked condition");
                logger.info(message.get());
            }
        }
    }

    /**
    * @param args
    */
    public static void main(String[] args) {
        Ex01.setLoggerLevel(Level.FINE);
        logIf(Level.SEVERE, () -> true, () -> "test");
    }

}
