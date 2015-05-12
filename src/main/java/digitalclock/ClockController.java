/**
 * @file
 * @par File Name:
 * ClockController.java
 * @author budougumi0617
 * @date Created on 2015/05/11
 */
package main.java.digitalclock;

import java.io.IOException;
import java.net.URL;
import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ClockController implements Initializable {
	private Timeline timeline;

	protected @FXML Label time;
	protected @FXML BorderPane mainPane;
	protected @FXML MenuBar menuBar;

	private Clock clock;
	protected Stage stage;

	public ClockController(Stage stage) {
		this.stage = stage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clock = Clock.tickSeconds(ZoneId.systemDefault());
		timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> updateTime()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	@FXML
	void showDialog(ActionEvent event) {
		try {
			Stage dialog = new Stage(StageStyle.UNDECORATED);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Dialog.fxml"));
			loader.setController(new DialogController(this));

			Parent root = (Parent) loader.load();

			Scene scene = new Scene(root);

			dialog.setScene(scene);
			dialog.initOwner(time.getScene().getWindow());
			dialog.setResizable(false);
			dialog.initModality(Modality.WINDOW_MODAL);

			dialog.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handleCloseAction(ActionEvent e) {
		System.out.println("Exit clock");
		System.exit(0);
	}

	private void updateTime() {
		time.setText(LocalTime.now(clock).format(DateTimeFormatter.ISO_TIME));
		// System.out.println(time.getFont().getName());
		// Text text = new Text("00:00:00");
		// text.setFont(time.getFont());
		// stage.setHeight(text.getLayoutBounds().getHeight()
		// * 1.5 + menuBar.getHeight());
		// stage.setWidth(text.getLayoutBounds().getWidth()
		// * 1.1);
		// System.out.println("width : " +
		// time.getWidth());
		// System.out.println("height : " +
		// time.getHeight());
	}
}
