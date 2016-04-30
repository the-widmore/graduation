package com.ccniit.graduation.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private DateUtils() {

	}

	private static DateFormat _y4M2d2 = new SimpleDateFormat("yyyy-MM-dd");
	private static DateFormat _y4M2d2h2m2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");

	// 一秒钟的毫秒数
	private static final int MS = 1000;

	public static final int MODEL_SECOND = 1;
	public static final int MODEL_MINUTE = MODEL_SECOND * 60;
	public static final int MODEL_HOUR = MODEL_MINUTE * 60;
	public static final int MODEL_DAY = MODEL_HOUR * 24;
	public static final int MODEL_WEEK = MODEL_DAY * 7;

	/**
	 * @param date
	 *            基础时间
	 * @param before
	 *            是否是之前时间
	 * @param mode
	 *            模式
	 * @param much
	 *            好久
	 */
	// 获取一个时间的好多(秒、分、小时、天、周)之前/之后的时间
	public static Date getDate(Date date, boolean before, int mode, long much) {
		long target = 0L;
		long fastTime = checkDate(date).getTime();
		if (before) {
			target = fastTime - (mode * much + MS);
		} else {
			target = fastTime + mode * much * MS;
		}
		return new Date(target);
	}

	public static Date getAfterDate(Date date, int mode, long much) {
		return getDate(date, false, mode, much);
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

	public static Date parseDate(String endDate) {
		Date date = null;
		try {
			date = _y4M2d2h2m2.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String betweenDistance(Date begain, Date end) {
		StringBuilder builder = new StringBuilder();

		// 如果时间相距大于一天
		Long between = end.getTime() - begain.getTime();
		if (between > (MODEL_DAY * MS)) {
			builder.append(between / (MODEL_DAY * MS)).append("天");
			builder.append((between % (MODEL_DAY * MS)) / (MODEL_HOUR * MS)).append("小时");
			return builder.toString();
		}
		int MINUTE_MS = MODEL_HOUR * MS;
		int hour = (int) (between / MINUTE_MS);
		int minute = (int) (between % MINUTE_MS) / (MODEL_MINUTE * MS);
		builder.append(hour).append("小时").append(minute).append("分钟");

		return builder.toString();
	}

	public static String betweenNow(Date date) {
		return betweenDistance(date, date);
	}

}
