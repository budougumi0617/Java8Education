/**
 * @file
 * @par File Name:
 * Ex12Test.java
 * @author budougumi0617
 * @date Created on 2015/04/07
 */
package test.java.ch8.ex12;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

import main.java.ch8.ex12.Ex12;
import main.java.ch8.ex12.TestCase;

import org.junit.Test;

/**
 * @author budougumi0617
 * @note Unit test using original annotation.
 */
public class Ex12Test {

	@Test
	public void executeTestUsingAnnotation() {
		@SuppressWarnings("rawtypes")
		Class clazz = Ex12.class;

		try {
			@SuppressWarnings("unchecked")
			Method method = clazz.getDeclaredMethod("targetMethod", int.class);
			Annotation[] annotations = method.getAnnotations();
			Arrays.stream(annotations)
					.filter(a -> a instanceof TestCase)
					.forEach(
							a -> {
								assertThat(Ex12.targetMethod(((TestCase) a).params()),
										is(((TestCase) a).expected()));
							});
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
