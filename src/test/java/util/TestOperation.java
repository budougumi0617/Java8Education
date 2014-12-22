/**
 * @file
 * @par File Name:
 * TestOperation.java
 * @author budougumi0617
 * @date Created on 2014/11/23
 */
package test.java.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author budougumi0617
 * @note privateなフィールド、メソッドをテストするためのUtilクラス
 */
@SuppressWarnings("rawtypes")
public class TestOperation {

	public static Object getPrivateField(Object target_object, String field_name)
			throws ReflectiveOperationException {
		Class c = target_object.getClass();
		System.out.println("Class name = " + c);
		Field fld = c.getDeclaredField(field_name);
		fld.setAccessible(true);
		return fld.get(target_object);
	}

	/**
	 * static privateフィールドの値を取得する関数
	 * 
	 * @param targetClass
	 *            Class name
	 * @param field_name
	 *            target class
	 * 
	 * @return value of static private field
	 * @throws ReflectiveOperationException
	 */
	public static Object getPrivateField(Class targeClass, String field_name)
			throws ReflectiveOperationException {
		Field fld = targeClass.getDeclaredField(field_name);
		fld.setAccessible(true);
		return fld.get(null);
	}

	public static void setPrivateField(Object target_object, String field_name,
			Object value) throws ReflectiveOperationException {
		Class c = target_object.getClass();
		Field fld = c.getDeclaredField(field_name);
		fld.setAccessible(true);
		fld.set(target_object, value);
	}

	public static void setPrivateField(Class targetClass, String field_name, Object value)
			throws ReflectiveOperationException {

		Field fld = targetClass.getDeclaredField(field_name);
		fld.setAccessible(true);
		fld.set(null, value);
	}

	@SuppressWarnings("unchecked")
	public static Object doPrivateMethod(Object targetObject, String methodName,
			Class[] classArray, Object[] args) throws ReflectiveOperationException {

		Class c = targetObject.getClass();

		Method method = c.getDeclaredMethod(methodName, classArray);
		method.setAccessible(true);

		return method.invoke(targetObject, args);
	}
}
