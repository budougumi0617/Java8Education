/**
 * @file
 * @par File Name:
 * TestOperation.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package main.java.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author budougumi0617
 * @note privateなフィールド、メソッドをテストするためのUtilクラス
 */
@SuppressWarnings("rawtypes")
public class TestOperation {

	public static Object getPrivateField(Object target_object, String field_name)
			throws Exception {
		Class c = target_object.getClass();
		Field fld = c.getDeclaredField(field_name);
		fld.setAccessible(true);

		return fld.get(target_object);
	}

	public static void setPrivateField(Object target_object, String field_name,
			Object value) throws Exception {
		Class c = target_object.getClass();
		Field fld = c.getDeclaredField(field_name);
		fld.setAccessible(true);
		fld.set(target_object, value);
	}

	@SuppressWarnings("unchecked")
	public static Object doPrivateMethod(Object target_object, String field_name,
			Class[] classArray, Object[] args) throws Exception {

		Class c = target_object.getClass();

		Method method = c.getDeclaredMethod(field_name, classArray);
		method.setAccessible(true);

		return method.invoke(target_object, args);
	}
}
