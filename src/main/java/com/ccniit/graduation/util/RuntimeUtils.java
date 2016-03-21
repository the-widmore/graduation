package com.ccniit.graduation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuntimeUtils {

	private static final Logger LOG = LoggerFactory.getLogger(RuntimeUtils.class);
	private static final long TOTAL_MEMORY = Runtime.getRuntime().totalMemory();

	private RuntimeUtils() {

	}

	// TODO
	public static double freeMemoryScale() {
		Runtime runtime = Runtime.getRuntime();
		long freeMemory = runtime.freeMemory();
		return NumberUtils.div(freeMemory, TOTAL_MEMORY, 2);
	}

}
