/**
 * @file
 * @par File Name:
 * Ex13.java
 * @author budougumi0617
 * @date Created on 2014/11/17
 */
package main.java.ch3.ex13;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author budougumi0617
 * @note ぼやけ検出、あるいは、エッジ検出といった畳み込みフィルターの
 *       操作を扱うために遅延画像処理の機能を強化しなさい。
 *       これらの演算の1つが評価される際に、 前段の計算が強制されるようにしなさい。
 */
public class Ex13 extends Application {

	public static double[][] getFilterOfEdge() {
		double filter[][] = new double[3][3];
		filter[1][1] = 4d;
		filter[0][1] = -1d;
		filter[1][0] = -1d;
		filter[1][2] = -1d;
		filter[2][1] = -1d;
		return filter;
	}

	public static double[][] getFilterOfAverage() {
		double filter[][] = new double[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				filter[i][j] = 0.111111;
			}
		}
		return filter;
	}

	@Override
	public void start(Stage stage) throws Exception {
		Image image = new Image("./main/resources/ch3/eiffel-tower.jpg");
		Image finalImage;

		finalImage = LatentImage.from(image).transform(getFilterOfEdge())
				.transform(getFilterOfEdge()).toImage();
		stage.setScene(new Scene(
				new HBox(new ImageView(image), new ImageView(finalImage))));
		stage.show();

	}

}

class LatentImage {
	private Image in;
	private static List<double[][]> pendingOperations;
	private static final int KERNEL_SIZE = 3;
	private static final int KERNEL_AREA = KERNEL_SIZE * KERNEL_SIZE;

	public static LatentImage from(Image in) {
		LatentImage result = new LatentImage();
		result.in = in;
		result.pendingOperations = new ArrayList<>();
		return result;
	}

	LatentImage transform(double[][] filter) {
		pendingOperations.add(filter);
		return this;
	}

	private static double[] getArrayFromFilter(double[][] filter) {
		double result[] = new double[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				result[i * 3 + j] = filter[i][j];
			}
		}
		return result;
	}

	private static double[] combineFilter() {
		double[] result = { 1d, 1d, 1d, 1d, 1d, 1d, 1d, 1d, 1d };
		pendingOperations.forEach((filter) -> {
			double f[] = getArrayFromFilter(filter);
			for (int i = 0; i < 9; i++) {
				result[i] = result[i] * f[i];
			}
		});
		return result;
	}

	public Image toImage() {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		Image result = in;
		for (double[][] filter : pendingOperations) {
			Image dest = toImage(result, filter);
			result = dest;
		}
		return result;
	}

	public Image toImage(Image in, double[][] filter) {
		// ピクセルの読み込みを行うPixelReaderを取得
		PixelReader reader = in.getPixelReader();

		int width = (int) in.getWidth();
		int height = (int) in.getHeight();

		// 書き込み用のイメージ
		WritableImage dest = new WritableImage(width, height);
		// ピクセルを書き込むPixelWriterの取得
		PixelWriter writer = dest.getPixelWriter();

		// ピクセルを読み込むためのバッファ
		int[] buffer = new int[KERNEL_AREA];
		double[] filterArray = getArrayFromFilter(filter);
		for (int i = 1; i < width - 1; i++) {
			for (int j = 1; j < height - 1; j++) {
				// ピクセルデータの読み込み
				reader.getPixels(i - 1, j - 1, KERNEL_SIZE, KERNEL_SIZE,
						PixelFormat.getIntArgbInstance(), buffer, 0, KERNEL_SIZE);

				// A R G Bの各色ごとに値の合計を求める
				int a = 0;
				double r = 0;
				double g = 0;
				double b = 0;
				for (int k = 0; k < KERNEL_AREA; k++) {

					a += (double) ((buffer[k] >> 24) & 0xff);
					r += (double) ((buffer[k] >> 16) & 0xff) * filterArray[k];
					g += (double) ((buffer[k] >> 8) & 0xff) * filterArray[k];
					b += (double) (buffer[k] & 0xff) * filterArray[k];
				}
				r = checkColorValue(r);
				g = checkColorValue(g);
				b = checkColorValue(b);

				// System.out.println("r= " + r +
				// " g= " + g + " b= " + b);
				// A R G
				// Bの値の合計から平均の値を算出し、Colorオブジェクトを生成
				Color color = Color.rgb((int) r, (int) g, (int) b, a / KERNEL_AREA
						/ 255.0);

				writer.setColor(i, j, color);
			}
		}

		return dest;
	}

	private int checkColorValue(double value) {
		if (value < 0) {
			return 0;
		} else if (value > 255) {
			return 255;
		} else {
			return (int) value;
		}
	}

}
