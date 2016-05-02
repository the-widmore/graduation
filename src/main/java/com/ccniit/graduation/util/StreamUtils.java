package com.ccniit.graduation.util;

import java.io.Closeable;
import java.io.IOException;

public class StreamUtils {

	private StreamUtils() {

	}

	public static void closeStream(Closeable stream) {
		try {
			stream.close();
		} catch (IOException e) {

		}
	}

}
