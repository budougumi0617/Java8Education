/**
 * @file
 * @par File Name:
 * Ex03.java
 * @author budougumi0617
 * @date Created on 2015/03/05
 */
package main.java.ch9.ex03;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex03 {
	private static final Logger logger = Logger.getLogger(Ex03.class.getName());
	public boolean flag = true;

	public void process(String exName) throws FileNotFoundException, UnknownHostException {
		try {

			if ("FileNotFoundException".equals(exName)) {
				throw new FileNotFoundException();
			} else {
				throw new UnknownHostException();
			}
		} catch (FileNotFoundException | UnknownHostException ex) {
			logger.log(Level.SEVERE, "Catch", ex);
			throw ex;
		}
	}
}
