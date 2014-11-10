/**
 * @file
 * @par File Name:
 * Ex15.java
 * @author budougumi0617
 * @date Created on 2014/11/10
 */
package main.java.ch3.ex15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

class LatentImage {
	private Color[][] in;
	private List<UnaryOperator<Color>> pendingOperations;

	public static LatentImage from(Image in) {
		LatentImage result = new LatentImage();
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		result.in = new Color[height][width];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				result.in[y][x] = in.getPixelReader().getColor(x, y);
			}

		}
		result.pendingOperations = new ArrayList<>();
		return result;
	}

	LatentImage transform(UnaryOperator<Color> f) {
		pendingOperations.add(f);
		return this;
	}

	public Image parallelToImage() {
		int n = Runtime.getRuntime().availableProcessors();
		int width = (int) in[0].length;
		int height = (int) in.length;
		Color[][] out = new Color[height][width];
		try {
			ExecutorService pool = Executors.newCachedThreadPool();
			for (int i = 0; i < n; i++) {
				int fromY = i * height / n;
				int toY = (i + 1) * height / n;
				pool.submit(() -> {
					System.out.printf("%s %d...%d\n", Thread.currentThread(), fromY,
							toY - 1);
					for (int x = 0; x < width; x++) {
						for (int y = fromY; y < toY; y++) {
							Color c = in[y][x];
							for (UnaryOperator<Color> f : pendingOperations) {
								c = f.apply(c);
							}
							out[y][x] = c;
						}
					}
				});
			}
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		WritableImage result = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				result.getPixelWriter().setColor(x, y, out[y][x]);
		return result;
	}
}

/**
 * @author budougumi0617
 * @note 69ページの3.6節「遅延」の遅延評価と70ページの3.7節「操作の並列化」
 *       の並列評価を組み合わせなさい。
 */
public class Ex15 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Image image = new Image("/main/resources/ch3/eiffel-tower.jpg");
		Image finalImage = LatentImage.from(image).transform(Color::brighter)
				.transform(Color::grayscale).parallelToImage();
		stage.setScene(new Scene(
				new HBox(new ImageView(image), new ImageView(finalImage))));
		stage.show();
	}

}
