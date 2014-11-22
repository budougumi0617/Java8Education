/**
 * @file
 * @par File Name:
 * Ex09.java
 * @author budougumi0617
 * @date Created on 2014/11/17
 */
package main.java.ch4.ex09;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author budougumi0617
 * @note 惑星を表す円をアニメーション化して、楕円軌道を回るようにしなさい。
 *       PathTransitionを使用します。
 */
@SuppressWarnings("deprecation")
public class Ex09 extends Application {

	private PathTransition orbitTransition;

	private void init(Stage stage) {

		Circle planet = new Circle(10, 10, 10);
		planet.setFill(Color.BLUE);
		Circle satellite = new Circle(40, 40, 40);
		satellite.setFill(Color.YELLOW);

		Pane pane = new Pane();
		pane.getChildren().add(planet);
		pane.getChildren().add(satellite);
		Scene scene = new Scene(pane, 300, 300);
		planet.centerXProperty().set(scene.widthProperty().get() / 2);
		planet.centerYProperty().set(scene.heightProperty().get() / 2);
		stage.setResizable(false);
		stage.setScene(scene);

		Path path = createPath(scene.widthProperty().get() / 2, scene.heightProperty()
				.get() / 2, 150, 100);

		orbitTransition = PathTransitionBuilder.create().duration(Duration.seconds(5))
				.path(path).node(satellite)
				.orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
				.cycleCount(Timeline.INDEFINITE).build();

	}

	private Path createPath(double centerX, double centerY, double radiusX, double radiusY) {
		ArcTo arcTo = new ArcTo();
		arcTo.setX(centerX + 1);
		arcTo.setY(centerY - radiusY);
		arcTo.setSweepFlag(false);
		arcTo.setLargeArcFlag(true);
		arcTo.setRadiusX(radiusX);
		arcTo.setRadiusY(radiusY);

		return PathBuilder.create()
				.elements(new MoveTo(centerX, centerY - radiusY), arcTo, new ClosePath())
				.build();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
		primaryStage.show();
		orbitTransition.play();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
