package com.ccniit.graduation.util;

public class ObjectUtils {

	private ObjectUtils() {

	}

	private static final String SIMPLE_OBJECT_PACKAGE = "java.lang";

	public static boolean isSimpleObject(Object obj) {
		String packageName = obj.getClass().getPackage().getName();
		if (SIMPLE_OBJECT_PACKAGE.equals(packageName)) {
			return true;
		}
		return false;
	}

}
