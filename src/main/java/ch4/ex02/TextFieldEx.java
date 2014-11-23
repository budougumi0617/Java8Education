/**
 * @file
 * @par File Name:
 * TextFieldEx.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package main.java.ch4.ex02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

/**
 * @author budougumi0617
 * @note TextFieldに遅延初期化を施したPropertyを追加したクラス
 */
public class TextFieldEx extends TextField {
	private StringProperty textEx;

	public final StringProperty textExProperty() {
		StringProperty result = textEx;
		if (result == null) { // ロックしないで検査
			synchronized (this) {
				result = textEx; // フィールドが既に初期化されている場合に必要
				if (result == null) { // ロックして検査
					result = textEx = new SimpleStringProperty("");
				}
			}
		}
		return result;
	}

	public final void setTextEx(String newValue) {
		textExProperty().set(newValue);
	}

	public final String getTextEx() {
		System.out.println("textEx = " + textEx);
		return textExProperty().get();
	}
}
