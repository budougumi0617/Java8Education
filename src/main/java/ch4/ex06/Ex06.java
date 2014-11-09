/**
 * @file
 * @par File Name:
 * Ex06.java
 * @author budougumi0617
 * @date Created on 2014/11/09
 */
package main.java.ch4.ex06;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author budougumi0617
 * @note 図4-7のTopとBottomとボタンを真ん中に揃えなさい。
 */
public class Ex06 extends Application {

	static Pane getPane() {
		BorderPane pane = new BorderPane();
		Button top = new Button("Top");
		pane.setTop(top);
		pane.setAlignment(top, Pos.CENTER);

		pane.setLeft(new Button("Left"));
		pane.setCenter(new Button("Center"));
		pane.setRight(new Button("Right"));
		Button bottom = new Button("Bottom");
		pane.setBottom(bottom);
		pane.setAlignment(bottom, Pos.CENTER);
		return pane;
	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setScene(new Scene(getPane()));
		stage.show();

	}

}
