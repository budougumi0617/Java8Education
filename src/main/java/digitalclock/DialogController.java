/**
 * @file
 * @par File Name:
 * DialogController.java
 * @author budougumi0617
 * @date Created on 2015/05/11
 */
package main.java.digitalclock;

import java.awt.GraphicsEnvironment;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DialogController implements Initializable {
	private ClockController clockController;

	private @FXML Label fontTypeLabel;
	private @FXML ComboBox<String> fontTypeBox;
	private @FXML ComboBox<Integer> fontSizeBox;
	private @FXML ColorPicker fontColorPicker;
	private @FXML ColorPicker backColorPicker;
	private @FXML Button cancleBtn;
	private @FXML Button okBtn;
	private ObservableList<String> fontTypeList;
	private ObservableList<Integer> fontSizeList;

	public DialogController(ClockController clockController) {
		this.clockController = clockController;
	}

	@FXML
	void handleCancelButtonAction(ActionEvent e) {
		fontTypeLabel.getScene().getWindow().hide();
		System.out.println(backColorPicker.getValue().toString());
		System.out.println("Handled cancelBtn action!");
	}

	@FXML
	void handleOkButtonAction(ActionEvent e) {
		clockController.time.setFont(new Font(fontTypeBox.getValue(), fontSizeBox
				.getValue()));
		System.out.println("Font : " + fontTypeBox.getValue());
		clockController.time.setTextFill(fontColorPicker.getValue());
		clockController.backColor = backColorPicker.getValue();
		clockController.mainPane.setStyle("-fx-background-color: "
				+ clockController.getRgb(clockController.backColor) + ";");
		Text text = new Text("00:00:00");
		text.setFont(clockController.time.getFont());
		clockController.stage.setHeight(text.getLayoutBounds().getHeight() * 1.5
				+ clockController.menuBar.getHeight());
		clockController.stage.setWidth(text.getLayoutBounds().getWidth() * 1.1);
		fontTypeLabel.getScene().getWindow().hide();
		System.out.println("width : " + clockController.time.getWidth());
		System.out.println("height : " + clockController.time.getHeight());
		System.out.println("Handled okBtn action!");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();
		fontTypeList = FXCollections.observableArrayList(fonts);
		fontTypeBox.setItems(fontTypeList);
		fontTypeBox.setValue(clockController.time.getFont().getName());
		fontSizeList = FXCollections.observableArrayList(50, 75, 100, 125, 150);
		fontSizeBox.setItems(fontSizeList);
		fontSizeBox.setValue(100);
		fontColorPicker.setValue((Color) clockController.time.getTextFill());
	}

}
