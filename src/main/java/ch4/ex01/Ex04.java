/**
 * @file
 * @par File Name:
 * Ex04.java
 * @author budougumi0617
 * @date Created on 2014/11/09
 */
package main.java.ch4.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author budougumi0617
 * @note テキストフィールドとラベルを持つプログラムを作成しなさい。「Hello,
 *       JavaFX」プログラムと同じように、 そのラベルは、文字列Hello,
 *       FXを100ポイントのフォントで表示するようにしなさい。
 *       テキストフィールドを同じ文字列で初期化しなさい。
 *       ユーザーがテキストフィールドを編集したらラベルも更新するようにしなさい。
 */
public class Ex04 extends Application {

	static Scene getScene() {
		Label label = new Label("Hello, JavaFX");
		label.setFont(new Font(100));
		TextField tf = new TextField("Hello, JavaFX");
		label.textProperty().bind(tf.textProperty());
		// tf.textProperty().addListener(property
		// -> label.setText(tf.getText()));
		BorderPane pane = new BorderPane();
		pane.setTop(label);
		pane.setBottom(tf);
		Scene scene = new Scene(pane);
		return scene;
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(getScene());
		stage.setTitle("Ex04");
		stage.show();

	}

}
