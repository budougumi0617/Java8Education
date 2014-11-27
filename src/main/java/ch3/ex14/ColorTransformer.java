/**
 * @file
 * @par File Name:
 * ColorTransformer.java
 * @author budougumi0617
 * @date Created on 2014/11/27
 */
package main.java.ch3.ex14;

import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
	public Color apply(int x, int y, PixelReader c);
}
