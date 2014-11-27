/**
 * @file
 * @par File Name:
 * Ex14.java
 * @author budougumi0617
 * @date Created on 2014/11/27
 */
package main.java.ch3.ex14;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author budougumi0617
 * @note ピクセル単位の遅延評価を扱うために、今までのトランスフォーマを変更して、
 *       画像内のほかのピクセルを読み込むことができる
 *       PixelReaderを渡すようにしなさい。 例えば(x,y,reader) ->
 *       reader.getColor(width -(x+1),y)は鏡像操作です。
 *       前の練習問題からの畳込みフィルターが
 *       あれば、リーダーの観点からは容易に実装できます。
 *       率直な操作は、単に(x,y,reader)->reader.getColor(x,
 *       y).grayscale()
 *       の形式であり、UnaryOperation<Color>からのアダプターを
 *       提供することができます。
 *       PixelReaderは、操作のパイプライン中の特定のレベルにあります。
 *       パイプライン中の個々のレベルで最近読み込まれた
 *       ピクセルのキャッシュを保持するようにしてください。
 *       ピクセルを求められたら、リーダーはキャッシュ
 *       （あるいはレベル０なら元画像）を調べます。
 *       ピクセルがなければリーダーを構築し、そのリーダーはピクセルを前段階で求めます。
 */
public class Ex14 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Image image = new Image("./main/resources/ch3/eiffel-tower.jpg");
		Image finalImage;

		finalImage = LatentImage
				.from(image)
				.transform((x, y, reader) -> reader.getColor(x, y).grayscale())
				.transform(
						(width, height, reader) -> {
							WritablePixelFormat<IntBuffer> format = WritablePixelFormat
									.getIntArgbInstance();
							int kernelSize = 3;
							int centerX = width - kernelSize;
							int centerY = height - kernelSize;
							int kernelWidth = kernelSize * 2 + 1;
							int kernelHeight = kernelSize * 2 + 1;

							if (centerX < 0) {
								centerX = 0;
								kernelWidth = width + kernelSize;
							} else if (width + kernelSize >= width) {
								kernelWidth = width - centerX;
							}

							if (centerY < 0) {
								centerY = 0;
								kernelHeight = height + kernelSize;
							} else if (height + kernelSize >= height) {
								kernelHeight = height - centerY;
							}

							int[] buffer = new int[kernelWidth * kernelHeight];
							reader.getPixels(centerX, centerY, kernelWidth, kernelHeight,
									format, buffer, 0, kernelWidth);

							double alpha = 0;
							int red = 0;
							int green = 0;
							int blue = 0;

							for (int color : buffer) {
								alpha += (color >>> 24);
								red += (color >>> 16 & 0xFF);
								green += (color >>> 8 & 0xFF);
								blue += (color & 0xFF);
							}

							alpha = alpha / kernelWidth / kernelHeight / 255d;
							red = red / kernelWidth / kernelHeight;
							green = green / kernelWidth / kernelHeight;
							blue = blue / kernelWidth / kernelHeight;

							return Color.rgb(red, green, blue, alpha);
						}).toImage();

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
		result.pendingOperations = new ArrayList<ColorTransformer>();
		return result;
	}

	LatentImage transform(ColorTransformer f) {
		pendingOperations.add(f);
		return this;
	}

	public Image toImage() {
		PixelReader reader = in.getPixelReader();

		int width = (int) in.getWidth();
		int height = (int) in.getHeight();

		WritableImage dest = new WritableImage(width, height);
		PixelWriter destWriter = dest.getPixelWriter();
		PixelReader destReader = dest.getPixelReader();
		WritableImage cache = new WritableImage(width, height);
		PixelReader cacheReader = cache.getPixelReader();
		PixelWriter cacheWriter = cache.getPixelWriter();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				cacheWriter.setColor(i, j, reader.getColor(i, j));
			}
		}

		pendingOperations.stream().forEachOrdered(f -> {
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					Color color = f.apply(i, j, cacheReader);
					destWriter.setColor(i, j, color);
				}
			}
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					cacheWriter.setColor(i, j, destReader.getColor(i, j));
				}
			}
		});

		return dest;
	}

}
