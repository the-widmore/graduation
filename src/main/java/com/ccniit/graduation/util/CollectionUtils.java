package com.ccniit.graduation.util;

import java.util.List;

public class CollectionUtils {

	private CollectionUtils() {

	}

	// 集合分割器
	public static <T> List<T> partition(List<T> list, int startIndex, int endIndex) {
		return list.subList(startIndex, endIndex);
	}

}
