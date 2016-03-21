package com.ccniit.graduation.util;

import java.math.BigDecimal;

public class NumberUtils {

	private NumberUtils() {

	}

	// 格式化小数,四舍五入
	public static double formatDouble(double value, int pointSize) {
		BigDecimal decimal = new BigDecimal(value);
		return decimal.setScale(pointSize, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static double div(double f, double s, int pointSize) {
		BigDecimal first = new BigDecimal(f);
		BigDecimal second = new BigDecimal(s);
		return first.divide(second, pointSize, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
