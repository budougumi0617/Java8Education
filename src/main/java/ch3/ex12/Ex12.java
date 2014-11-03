/**
 * @file
 * @par File Name:
 * Ex12.java
 * @author budougumi0617
 * @date Created on 2014/11/03
 */
package main.java.ch3.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.ch3.ex05.ColorTransformer;

/**
 * @author budougumi0617
 * @note 69ページの3.6節「遅延」のLatentImageを機能拡張して、
 *       UnaryOperator<Color>と
 *       ColorTransformerの両方をサポートするようにしなさい。
 *       ヒント：UnaryOperator
 *       <Color>をColorTransformerへ適応させなさい。
 * @note "$ cd ${GRADLE_HOME}/src"
 *       "$ javac main/java/ch3/ex12/*.java"
 *       "$ java main.java.ch3.ex12.Ex12"
 */
public class Ex12 extends Application {
	public void start(Stage stage) {
		Image image = new Image("./main/resources/ch3/eiffel-tower.jpg");
		Image finalImage = LatentImage.from(image).transform(Color::brighter)
				.transform(Color::grayscale).toImage();
		stage.setScene(new Scene(
				new HBox(new ImageView(image), new ImageView(finalImage))));
		stage.show();
	}
}

class LatentImage {
	private Image in;
	private List<ColorTransformer> pendingOperations;

	public static LatentImage from(Image in) {
		LatentImage result = new LatentImage();
		result.in = in;
		result.pendingOperations = new ArrayList<>();
		return result;
	}

	LatentImage transform(UnaryOperator<Color> f) {
		pendingOperations.add((x, y, c) -> f.apply(c));
		return this;
	}

	LatentImage transform(ColorTransformer f) {
		pendingOperations.add(f);
		return this;
	}

	public Image toImage() {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
				Color c = in.getPixelReader().getColor(x, y);
				for (ColorTransformer f : pendingOperations)
					c = f.apply(x, y, c);
				out.getPixelWriter().setColor(x, y, c);
			}
		return out;
	}
}