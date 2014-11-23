/**
 * @file
 * @par File Name:
 * Ex03.java
 * @author budougumi0617
 * @date Created on 2014/11/10
 */
package main.java.ch3.ex11;

import java.util.function.UnaryOperator;

import javafx.application.Application;
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
 * @note 2つのColorTransformerオブジェクトを合成できる
 *       staticメソッドを実装しなさい 。 そして、x座標とy座標を無視する
 *       ColorTransformerへ
 *       UnaryOperator<Color>を変えるstaticメソッドを
 *       実装しなさい。 それから、変数によって明るくなった画像に
 *       灰色の枠を追加するために、実装したメソッドを 使用しなさい
 *       （灰色の枠に関しては練習問題5を参照しなさい）。
 */
public class Ex11 extends Application {

	public static ColorTransformer composeColorTransformer(ColorTransformer ct1,
			ColorTransformer ct2) {
		return (x, y, c) -> ct1.apply(x, y, ct2.apply(x, y, c));
	}

	public static ColorTransformer convertToColorTransformer(UnaryOperator<Color> uo) {
		return (x, y, c) -> uo.apply(c);
	}

	public static Image createImage(Image image) {
		return Ex05.transform(
				image,
				composeColorTransformer((x, y, c) -> x < 10 || x > image.getWidth() - 10
						|| y < 10 || y > image.getHeight() - 10 ? Color.GRAY : c,
						convertToColorTransformer(Color::brighter)));
	}

	@Override
	public void start(Stage stage) {
		Image image = new Image("./main/resources/ch3/queen-mary.png");
		Image image2 = createImage(image);
		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
		stage.show();

	}
}
