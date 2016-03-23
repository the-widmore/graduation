package com.ccniit.graduation.util;

public class RuntimeUtils {

	private static final long TOTAL_MEMORY = Runtime.getRuntime().totalMemory();

	private RuntimeUtils() {

	}

	// 计算JavaVM的空闲内存 TODO
	public static double freeMemoryScale() {
		Runtime runtime = Runtime.getRuntime();
		long freeMemory = runtime.freeMemory();
		return NumberUtils.div(freeMemory, TOTAL_MEMORY, 2);
	}

}
