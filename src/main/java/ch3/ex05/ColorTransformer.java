/**
 * @file
 * @par File Name:
 * ColorTransformer.java
 * @author budougumi0617
 * @date Created on 2014/11/03
 */
package main.java.ch3.ex05;

import javafx.scene.paint.Color;

/**
 * @author budougumi0617
 * @note no comment
 */
@FunctionalInterface
public interface ColorTransformer {
	public Color apply(int x, int y, Color c);
}
