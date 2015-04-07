/**
 * @file
 * @par File Name:
 * TestCase.java
 * @author budougumi0617
 * @date Created on 2015/04/07
 */
package main.java.ch8.ex12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/**
 * @author budougumi0617
 * @note My annotation
 */
@Repeatable(TestCases.class)
@Target(ElementType.METHOD)
public @interface TestCase {
	int params();

	int expected();
}

@Target(ElementType.METHOD)
@interface TestCases {
	TestCase[] value();
}
