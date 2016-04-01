package com.ccniit.graduation.util;

import java.util.Arrays;
import java.util.Iterator;

import org.springframework.web.context.request.WebRequest;

public class WebUtils {

	private WebUtils() {

	}

	/**
	 * 使用Spring Web提供的接口。不使用Servlet API
	 */
	public static String getRequestParamsAndValues(WebRequest request) {
		String nextLine = StringUtils.nextLine();

		Iterator<String> parameterNames = request.getParameterNames();
		String contextPath = request.getContextPath();
		StringBuilder requestParametersBuild = new StringBuilder();
		requestParametersBuild.append(contextPath).append(" : {");
		requestParametersBuild.append(nextLine);

		while (parameterNames.hasNext()) {

			String parameterName = parameterNames.next();
			String[] values = request.getParameterValues(parameterName);

			requestParametersBuild.append(parameterName).append(':');

			int valuesLength = values.length;

			if (0 == valuesLength) {
				requestParametersBuild.append("<nul>");
			} else if (1 == valuesLength) {
				requestParametersBuild.append(values[0]);
			} else {
				requestParametersBuild.append(Arrays.toString(values));
			}

			requestParametersBuild.append(";").append(nextLine);
		}

		requestParametersBuild.append("}");

		return requestParametersBuild.toString();
	}

}
