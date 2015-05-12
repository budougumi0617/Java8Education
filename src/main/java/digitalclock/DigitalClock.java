/**
 * @file
 * @par File Name:
 * DigitalClock.java
 * @author budougumi0617
 * @date Created on 2015/05/11
 */
package main.java.digitalclock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author budougumi0617
 * @note Entry class
 */
public class DigitalClock extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader clockLoader = new FXMLLoader(getClass().getResource("Clock.fxml"));
		clockLoader.setController(new ClockController(primaryStage));
		Parent root = (Parent) clockLoader.load();

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
