package com.ccniit.graduation.util;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class SpringMVCUtils {

	private SpringMVCUtils() {

	}

	public static String redirect(String to) {
		return "redirect:".concat(to);
	}

	public static ModelAndView redirect(String to, RedirectAttributes attributes) {
		return new ModelAndView(redirect(to));
	}

	@SuppressWarnings("unchecked")
	public static <T> T getParameterValues(WebRequest request, String paramName, T t) {
		Object parameterValue = request.getParameterValues(paramName)[0];
		try {
			return (T) parameterValue;
		} catch (ClassCastException e) {
			// TODO logger
		}

		return null;
	}

}
