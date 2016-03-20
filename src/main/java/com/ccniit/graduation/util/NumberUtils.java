package com.ccniit.graduation.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberUtils {

	private NumberUtils() {

	}

	// 格式化小数
	public static double formatDouble(double value, int pointSize) {
		NumberFormat decimalFormat = DecimalFormat.getInstance();
		decimalFormat.setMaximumFractionDigits(pointSize);
		return Double.parseDouble(decimalFormat.format(value));
	}

	public static double div(double f, double s) {
		BigDecimal first = new BigDecimal(f);
		BigDecimal second = new BigDecimal(s);
		BigDecimal result = first.divide(second, 100, 5);
		return formatDouble(result.doubleValue(), 2);
	}

}
