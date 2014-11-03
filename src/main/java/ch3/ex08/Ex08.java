/**
 * @file
 * @par File Name:
 * Ex08.java
 * @author budougumi0617
 * @date Created on 2014/11/03
 */
package main.java.ch3.ex08;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.ch3.ex05.ColorTransformer;
import main.java.ch3.ex05.Ex05;

/**
 * @author budougumi0617
 * @note 画像に任意の幅と色の枠を追加するColorTransformerを生成するように、
 *       staticメソッドを書いて、 練習問題5を汎用化しなさい。
 * @note "$ cd ${GRADLE_HOME}/src"
 *       "$ javac main/java/ch3/ex08/*.java"
 *       "$ java main.java.ch3.ex08.Ex08"
 */
public class Ex08 extends Ex05 {
	public static ColorTransformer generateColorTransformer(Image image, int width,
			Color color) {
		return (x, y, c) -> {
			if (x < width || x > image.getWidth() - width || y < width
					|| y > image.getHeight() - width) {
				return color;
			} else {
				return c;
			}
		};
	}

	@Override
	public void start(Stage stage) {
		Image image = new Image("./main/resources/ch3/queen-mary.png");
		Image image2 = transform(image,
				Ex08.generateColorTransformer(image, 20, Color.RED));

		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
		stage.show();
	}
}
