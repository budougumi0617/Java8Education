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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ClockController implements Initializable {
	private final String STAGE_X = "stage-x";
	private final String STAGE_Y = "stage-y";
	private final String STAGE_WIDTH = "stage-width";
	private final String STAGE_HEIGHT = "stage-height";
	private final String FONT_SIZE = "font-size";
	private final String FONT_TYPE = "font-type";
	private final String BACK_COLOR_R = "back-color-r";
	private final String BACK_COLOR_G = "back-color-g";
	private final String BACK_COLOR_B = "back-color-b";
	private final String BACK_COLOR_O = "back-color-o";
	private final String FONT_COLOR = "font-color";
	private Timeline timeline;

	protected @FXML Label time;
	protected @FXML BorderPane mainPane;
	protected @FXML MenuBar menuBar;

	private Clock clock;
	protected Stage stage;
	protected Color backColor;
	private PrefsData prefs;

	/**
	 * Constructor using primary stage
	 * 
	 * @param stage
	 *            Primary stage.
	 */
	public ClockController(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Initialized Clock view
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prefs = new PrefsData();
		time.setFont(new Font(prefs.loadString(FONT_TYPE, "hoge"), prefs.loadDouble(
				FONT_SIZE, 50.)));
		System.out.println("font size : " + time.getFont().getSize());
		System.out.println("font name : " + time.getFont().getName());
		time.setTextFill(Color.web(prefs.loadString(FONT_COLOR, "0x000000")));
		backColor = new Color(prefs.loadDouble(BACK_COLOR_R, 1.), prefs.loadDouble(
				BACK_COLOR_G, 1.), prefs.loadDouble(BACK_COLOR_B, 1.),
				prefs.loadDouble(BACK_COLOR_O, 1));
		stage.setX(prefs.loadDouble(STAGE_X, 300.));
		stage.setY(prefs.loadDouble(STAGE_Y, 100.));
		stage.setWidth(prefs.loadDouble(STAGE_WIDTH, 214.));
		stage.setHeight(prefs.loadDouble(STAGE_HEIGHT, 116.));
		mainPane.setStyle("-fx-background-color: " + getRgb(backColor) + ";");
		clock = Clock.tickSeconds(ZoneId.systemDefault());
		timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> updateTime()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		stage.setOnCloseRequest((eh) -> {
			savePrefs();
		});

		timeline.play();
	}

	/**
	 * Open Configuration dialog
	 * 
	 * @param event
	 *            no used
	 */
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
			dialog.setX(stage.getX() + 10.);
			dialog.setY(stage.getY() - 10.);

			dialog.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Terminate process
	 * 
	 * @param event
	 *            No used.
	 */
	@FXML
	private void handleCloseAction(ActionEvent e) {
		System.out.println("Exit clock");
		savePrefs();
		System.exit(0);
	}

	/**
	 * Save clock setting
	 */
	private void savePrefs() {
		prefs.saveDouble(STAGE_X, stage.getX());
		prefs.saveDouble(STAGE_Y, stage.getY());
		prefs.saveDouble(STAGE_WIDTH, stage.getWidth());
		prefs.saveDouble(STAGE_HEIGHT, stage.getHeight());
		System.out.println("font size : " + time.getFont().getSize());
		prefs.saveDouble(FONT_SIZE, time.getFont().getSize());
		prefs.saveString(FONT_TYPE, time.getFont().getName());
		System.out.println("textFill :" + time.getTextFill().toString());
		prefs.saveString(FONT_COLOR, time.getTextFill().toString());
		prefs.saveDouble(BACK_COLOR_R, backColor.getRed());
		prefs.saveDouble(BACK_COLOR_G, backColor.getGreen());
		prefs.saveDouble(BACK_COLOR_B, backColor.getBlue());
		prefs.saveDouble(BACK_COLOR_O, backColor.getOpacity());
	}

	/**
	 * update time by current time
	 */
	private void updateTime() {
		time.setText(LocalTime.now(clock).format(DateTimeFormatter.ISO_TIME));
	}

	/**
	 * Change color value to CSS format
	 * 
	 * @param c
	 *            Original color
	 * @return Color by string using CSS format
	 */
	protected String getRgb(Color c) {
		String result = "rgba( ";
		result += getRGBValue(c.getRed()) + "," + getRGBValue(c.getGreen()) + ","
				+ getRGBValue(c.getBlue()) + "," + c.getOpacity() + ")";
		System.out.println("color string: " + result);
		return result;
	}

	/**
	 * Convert RGB value from Color.getXXX()
	 * format to 1-255
	 * 
	 * @param d
	 *            RGB value get from
	 *            Color.getXXX(). 0-1.0
	 * @return RGB value. 1-255
	 */
	private int getRGBValue(double d) {
		return (int) (255 * d);
	}
}
