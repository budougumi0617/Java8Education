/**
 * @file
 * @par File Name:
 * Ex05.java
 * @author budougumi0617
 * @date Created on 2014/11/01
 */
package main.java.ch3.ex05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author budougumi0617
 * @note 次は、ColorTransformerの具体例です。
 *       次のように、画像の周りに枠を負荷します。
 *       最初に、62ページの3.3節「関数型インターフェースの選択」の
 *       transformメソッドを、 UnaryOperator<Color>
 *       の変わりにColorTransformerで実装しなさい。それから、
 *       画像の周りの10ピクセルを灰色の枠で置き換えるために
 *       、そのtransformメソッドを 適切なラムダ式で呼び出しなさい。
 * @note "$ cd ${GRADLE_HOME}/src"
 *       "$ javac main/java/ch3/ex05/*.java"
 *       "$ java main.java.ch3.ex05.Ex05"
 */
public class Ex05 extends Application {

	public static Image transform(Image in, ColorTransformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y,
						f.apply(x, y, in.getPixelReader().getColor(x, y)));
		return out;
	}

	public void start(Stage stage) {
		Image image = new Image("./main/resources/ch3/queen-mary.png");
		Image image2 = transform(image, (x, y, c) -> x < 10 || x > image.getWidth() - 10
				|| y < 10 || y > image.getHeight() - 10 ? Color.GRAY : c);

		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
		stage.show();
	}
}
