/**
 * @file
 * @par File Name:
 * Ex04.java
 * @author budougumi0617
 * @date Created on 2014/11/09
 */
package main.java.ch4.ex10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author budougumi0617
 * @note WebViewerを使用して、URLバーと戻るボタンを持つブラウザを実装しなさい。
 *       ヒント:WebEngine.getHistory()
 */
public class Ex10 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		String location = "http://horstmann.com";
		WebView browser = new WebView();
		WebEngine engine = browser.getEngine();
		engine.load(location);
		BorderPane bp = new BorderPane();
		TextField tf = new TextField(location);
		bp.setLeft(tf);
		Button backBt = new Button("Back");
		backBt.setOnAction(event -> {
			engine.getHistory().go(-1);
		});
		bp.setCenter(backBt);
		Button goBt = new Button("Go");
		goBt.setOnAction(event -> {
			engine.load(tf.getText());
		});
		bp.setRight(goBt);
		bp.setBottom(browser);
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.setWidth(500);
		stage.setHeight(500);
		stage.show();
	}

}
