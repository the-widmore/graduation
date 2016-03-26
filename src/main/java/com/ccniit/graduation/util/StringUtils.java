package com.ccniit.graduation.util;

import java.text.DecimalFormat;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;

public class StringUtils {

	private StringUtils() {

	}

	// 获取一个32位的UUID，除去'-'
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}

	private static final String _ = "_";

	// 获取一个带开始为下划线的UUID
	public static String _getUUID() {
		return _.concat(getUUID());
	}

	// 获取系统换行符，兼容不同平台
	public static String nextLine() {
		return System.getProperty("line.separator");
	}

	// 字符串分割
	public static String[] split(String source, String sub) {
		return source.split(sub);
	}

	// 获取指定长度一个子串，从左到右
	public static String getLeftString(String original, int length) {
		if (original.length() > length) {
			return original.substring(0, (length - 1));
		}
		return original;
	}

	private static DecimalFormat decimalFormat = new DecimalFormat("#");

	// 将一个Decimal格式化成一个字符串
	public static String formatDecimal(double value) {
		return decimalFormat.format(value);
	}

	private static final String WORDS_CHARS = "QAZWSXEDCRFVTGBYHNUJMIKOLP0987654321poiuytrewqasdfghjklmnbvcxz";

	// 获取指定长度的随机字符
	public static String getRandomString(int length) {
		return RandomStringUtils.random(length, WORDS_CHARS);
	}

}
