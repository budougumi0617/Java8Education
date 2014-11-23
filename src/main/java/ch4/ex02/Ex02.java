/**
 * @file
 * @par File Name:
 * Ex02.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package main.java.ch4.ex02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author budougumi0617
 * @note チャートやテーブルといった多くのJavaFXプロパティを持つクラスを考えなさい。
 *       特定のアプリケーションでは、
 *       ほとんどのプロパティには決してリスナーが登録されない可能性が高いです。
 *       したがって、プロパティごとにプロパティオブジェクトを持つことは無駄です。
 *       プロパティ値を保存するために最初に普通のフィールドを使用して
 *       、初めてxxxProperty()メソッドが呼び出されたときに、
 *       要求に応じてプロパティを構築する方法を示しなさい。
 */
public class Ex02 extends Application {
	static Scene getScene() {
		Label label = new Label("Hello, JavaFX");
		label.setFont(new Font(100));
		TextFieldEx tf = new TextFieldEx();
		tf.getTextEx();
		tf.setTextEx("test");
		System.out.println("textEx = " + tf.getTextEx());
		label.textProperty().bind(tf.textProperty());
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
