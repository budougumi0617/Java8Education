/**
 * @file
 * @par File Name:
 * Ex10.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package main.java.ch3.ex10;

import java.util.function.UnaryOperator;

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
 * @note README.md参照
 */
public class Ex10 extends Application {
	public static Image transform(Image in, UnaryOperator<Color> f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y,
						f.apply(in.getPixelReader().getColor(x, y)));
		return out;
	}

	public static UnaryOperator<Color> brighten(double factor) {
		return c -> c.deriveColor(0, 1, factor, 1);
	}

	public void start(Stage stage) {
		Image image = new Image("./main/resources/ch3/queen-mary.png");
		UnaryOperator<Color> op = Color::brighter;
		// Image finalImage = transform(image,
		// (UnaryOperator<Color>)
		// op.compose(Color::grayscale));
		stage.setScene(new Scene(new HBox(new ImageView(image))));
		stage.show();
	}
}
