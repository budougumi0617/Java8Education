/**
 * @file
 * @par File Name:
 * Ex04.java
 * @author budougumi0617
 * @date Created on 2014/11/10
 */
package main.java.ch4.ex04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author budougumi0617
 * @note 91ページの4.5節「バインディング」のプログラムについて、円が真ん中に配置され、
 *       シーンの4つの辺の少なくとも2つの辺に常に接するように機能拡張しなさい。
 */
public class Ex04 extends Application {

	public static Scene createScene() {
		Circle circle = new Circle(100, 100, 100);
		circle.setFill(Color.RED);
		Pane pane = new Pane();
		pane.getChildren().add(circle);
		Scene scene = new Scene(pane);
		circle.centerXProperty().bind(Bindings.divide(scene.widthProperty(), 2));
		circle.centerYProperty().bind(Bindings.divide(scene.heightProperty(), 2));
		circle.radiusProperty().bind(
				Bindings.divide(
						Bindings.when(
								Bindings.lessThanOrEqual(scene.widthProperty(),
										scene.heightProperty()))
								.then(scene.widthProperty())
								.otherwise(scene.heightProperty()), 2));
		return scene;
	}

	@Override
	public void start(Stage stage) {

		stage.setScene(createScene());
		stage.show();

	}
}
