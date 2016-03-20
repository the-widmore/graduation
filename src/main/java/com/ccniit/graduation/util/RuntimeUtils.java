package com.ccniit.graduation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuntimeUtils {

	private static final Logger LOG = LoggerFactory.getLogger(RuntimeUtils.class);

	private RuntimeUtils() {

	}

	// TODO
	public static double freeMemoryScale() {
		Runtime runtime = Runtime.getRuntime();
		long totalMemory = runtime.totalMemory();
		long freeMemory = runtime.freeMemory();

		double scale = freeMemory / totalMemory;

		Object[] logs = { totalMemory, freeMemory, scale };

		LOG.info("{},{},{}", logs);

		return NumberUtils.formatDouble(scale, 3);
	}

	public static void main(String[] args) {
		System.out.println(freeMemoryScale());
	}

}
