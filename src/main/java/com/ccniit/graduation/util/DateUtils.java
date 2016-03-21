package com.ccniit.graduation.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private DateUtils() {

	}

	private static DateFormat _y4M2d2 = new SimpleDateFormat("yyyy-MM-dd");

	public static String y4M2d2(Date date) {
		return _y4M2d2.format(check(date));
	}

	private static Date check(Date date) {
		if (null == date) {
			return new Date();
		} else {
			return date;
		}
	}

}
