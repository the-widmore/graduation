package com.ccniit.graduation.util;

import java.text.DecimalFormat;
import java.util.UUID;

public class StringUtils {

	private StringUtils() {
	}

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();

		return uuid.toString().replace("-", "");
	}

	public static String nextLine() {
		return System.getProperty("line.separator");
	}

	public static String[] split(String source, String sub) {
		return source.split(sub);
	}

	public static String getLeftString(String original, int length) {
		if (original.length() > length) {
			return original.substring(0, (length - 1));
		}
		return original;
	}

	private static DecimalFormat decimalFormat = new DecimalFormat("#");

	public static String formatDecimal(double value) {
		return decimalFormat.format(value);
	}

}
