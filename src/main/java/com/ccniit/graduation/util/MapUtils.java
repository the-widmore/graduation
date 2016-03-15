package com.ccniit.graduation.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapUtils {

	public static final Logger LOG = LoggerFactory.getLogger(MapUtils.class);

	private MapUtils() {

	}

	public static void printMap(Map<?, ?> map, OutputStream outputStream) {
		StringBuilder mapEntryString = new StringBuilder("");
		String nextLine = StringUtils.nextLine();

		for (Entry<?, ?> entry : map.entrySet()) {
			mapEntryString.append(entry.getKey());
			mapEntryString.append(" : ");
			mapEntryString.append(entry.getValue());
			mapEntryString.append(" ,").append(nextLine);
		}

		try {
			outputStream.write(mapEntryString.toString().getBytes());
		} catch (IOException e) {
			LOG.error("");
		}
	}

}
