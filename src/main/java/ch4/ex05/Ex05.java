/**
 * @file
 * @par File Name:
 * Ex05.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package main.java.ch4.ex05;

import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author budougumi0617
 * @note README.md参照
 */
public class Ex05 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Button smaller = new Button("Smaller");
		Button larger = new Button("Larger");
		Rectangle gauge = new Rectangle(0, 5, 50, 15);
		Rectangle outline = new Rectangle(0, 5, 100, 15);
		outline.setFill(null);
		outline.setStroke(Color.BLACK);
		Pane pane = new Pane();
		pane.getChildren().addAll(gauge, outline);
		smaller.setOnAction(event -> gauge.setWidth(gauge.getWidth() - 10));
		larger.setOnAction(event -> gauge.setWidth(gauge.getWidth() + 10));
		smaller.disableProperty().bind(
				observe(t -> t.doubleValue() <= 0d, gauge.widthProperty()));
		larger.disableProperty().bind(
				observe(t -> t.doubleValue() >= 100d, gauge.widthProperty()));
		HBox box = new HBox(10);
		box.getChildren().addAll(smaller, pane, larger);
		Scene scene = new Scene(box);
		stage.setScene(scene);
		stage.show();

	}

	public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
		return new ObservableValue<R>() {

			@Override
			public void addListener(InvalidationListener listener) {
				t.addListener(listener);
			}

			@Override
			public void removeListener(InvalidationListener listener) {
				t.removeListener(listener);
			}

			@SuppressWarnings("unchecked")
			@Override
			public void addListener(ChangeListener<? super R> listener) {
				t.addListener((ChangeListener<? super T>) listener);

			}

			@SuppressWarnings("unchecked")
			@Override
			public void removeListener(ChangeListener<? super R> listener) {
				t.removeListener((ChangeListener<? super T>) listener);
			}

			@Override
			public R getValue() {
				return f.apply(t.getValue());
			}
		};
	}

	public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f,
			ObservableValue<T> t, ObservableValue<U> u) {
		return new ObservableValue<R>() {

			@Override
			public void addListener(InvalidationListener listener) {
				t.addListener(listener);
				u.addListener(listener);
			}

			@Override
			public void removeListener(InvalidationListener listener) {
				t.removeListener(listener);
				u.removeListener(listener);
			}

			@SuppressWarnings("unchecked")
			@Override
			public void addListener(ChangeListener<? super R> listener) {
				t.addListener((ChangeListener<? super T>) listener);
				u.addListener((ChangeListener<? super U>) listener);
			}

			@SuppressWarnings("unchecked")
			@Override
			public void removeListener(ChangeListener<? super R> listener) {
				t.removeListener((ChangeListener<? super T>) listener);
				u.removeListener((ChangeListener<? super U>) listener);
			}

			@Override
			public R getValue() {
				return f.apply(t.getValue(), u.getValue());
			}
		};
	}

}
