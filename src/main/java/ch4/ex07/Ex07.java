/**
 * @file
 * @par File Name:
 * Ex07.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package main.java.ch4.ex07;

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
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author budougumi0617
 * @note CSSを使用しないで、コントロールの境界を設定する方法を調べなさい。
 * @see <a href=
 *      "https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html">
 *      CSS reference guide</a>
 */
public class Ex07 extends Application implements Initializable {
	@FXML
	private SplitPane rootPane;
	@FXML
	private TextField bigField;
	@FXML
	private TextField smallField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootPane.orientationProperty().set(Orientation.VERTICAL);
		rootPane.setMinSize(500d, 200d);
		bigField.setPrefWidth(500d);
		bigField.setStyle("-fx-background-color: mistyrose");
		smallField.setFont(new Font(100));
		smallField.setPrefWidth(200d);
		smallField.setMaxWidth(200d);
		smallField.setStyle("-fx-background-color: red");

	}

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Ex07.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(0);
		}

	}

}
