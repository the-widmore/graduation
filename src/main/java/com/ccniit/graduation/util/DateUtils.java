package com.ccniit.graduation.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private DateUtils() {

	}

	private static DateFormat _y4M2d2 = new SimpleDateFormat("yyyy-MM-dd");
	private static DateFormat _y4M2d2h2m2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");

	public static final int model_second = 1;
	public static final int model_minute = model_second * 60;
	public static final int model_hour = model_minute * 60;
	public static final int model_day = model_hour * 24;
	public static final int model_week = model_day * 7;

	// 一秒钟的毫秒数
	private static final int MS = 1000;

	public static Date getAfterDate(Date date, int mode, long after) {
		long fastTime = checkDate(date).getTime();
		long target = fastTime + mode * after * MS;
		return new Date(target);
	}

	public static String y4M2d2(Date date) {
		return _y4M2d2.format(checkDate(date));
	}

	public static String y4M2d2h2m2(Date date) {
		return _y4M2d2h2m2.format(checkDate(date));
	}

	private static Date checkDate(Date date) {
		if (null == date) {
			return new Date();
		} else {
			return date;
		}
	}

}
