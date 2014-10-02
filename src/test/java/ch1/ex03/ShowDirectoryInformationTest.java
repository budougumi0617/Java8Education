/**
 * @file
 * @par File Name:
 * ShowDirectoryInformationTest.java
 * @author budougumi0617
 * @date Created on 2014/09/30
 */
package test.java.ch1.ex03;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import main.java.ch1.ex03.ShowDirectoryInformation;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note no comment
 */
public class ShowDirectoryInformationTest {
	
	ShowDirectoryInformation testTarget;
	
	@Test
	public void returnNotNull() {
		File currentDir = new File("./");
		String exType = "class";
		List<String> result = ShowDirectoryInformation.getExtensionList(currentDir, exType);
		assertThat(result.isEmpty(),is(false));
	}
	@Test
	public void test2() {
		fail("For checking Travis CI");
	}

}
