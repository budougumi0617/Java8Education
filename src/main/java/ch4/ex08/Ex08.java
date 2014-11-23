/**
 * @file
 * @par File Name:
 * Ex08.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package main.java.ch4.ex08;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author budougumi0617
 * @note FXMLファイルを解析する際には、JavaFX固有の知識は必要としません。
 *       JavaFXで何もせずに、 入れ子になっているオブジェクトをロードし、
 *       FXML構文でプロパティを設定する例を作成しなさい。
 *       注入を使用できたら、さらに良いです。
 */
public class Ex08 extends Application implements Initializable {
	@FXML
	private SplitPane rootPane;
	@FXML
	private TextField inputField;
	@FXML
	private Label showLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootPane.orientationProperty().set(Orientation.VERTICAL);
		rootPane.setMinSize(500d, 200d);
		inputField.setText("From Ex08.java");
		showLabel.setFont(new Font(100));
		showLabel.textProperty().bind(inputField.textProperty());

	}

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Ex08.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(0);
		}

	}
}
