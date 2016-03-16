package com.ccniit.graduation.util;

public class SpringMVCUtils {

	private SpringMVCUtils() {

	}

	public static String redirect(String to) {
		return "redirect:/".concat(to);
	}

}
