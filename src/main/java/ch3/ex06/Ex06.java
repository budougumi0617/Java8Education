/**
 * @file
 * @par File Name:
 * Ex06.java
 * @author budougumi0617
 * @date Created on 2014/11/03
 */
package main.java.ch3.ex06;

import java.util.function.BiFunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

@FunctionalInterface
interface ColorTransformer {
	public Color apply(int x, int y, Color c);

}

/**
 * @author budougumi0617
 * @note 65ページの3.4節「関数を返す」で見た次のメソッドを完成させなさい。
 *       public static<T> Image transform ( Image
 *       in, BiFunction<Color, T> f, T arg)
 * @note "$ cd ${GRADLE_HOME}/src"
 *       "$ javac main/java/ch3/ex06/Ex06.java"
 *       "$ java main.java.ch3.ex06.Ex06"
 */
public class Ex06 extends Application {

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

	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y,
						f.apply(in.getPixelReader().getColor(x, y), arg));
		return out;
	}

	public void start(Stage stage) {
		Image image = new Image("./main/resources/ch3/queen-mary.png");
		Image brightenedImage = transform(image,
				(c, factor) -> c.deriveColor(0, 1, factor, 1), 2.);

		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(
				brightenedImage))));
		stage.show();
	}
}
