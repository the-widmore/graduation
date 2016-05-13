package com.ccniit.graduation.util;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class CollectionUtils {

	private CollectionUtils() {

	}

	/** 集合分割器 */
	public static <T> List<T> partition(List<T> list, int startIndex, int endIndex) {
		return list.subList(startIndex, endIndex);
	}

	private static final String DEFAULT_SEPARATOR = ",";

	/**
	 * 构建集合字符串
	 * 
	 * @param colls
	 *            要处理的集合
	 * @param separator
	 *            分隔符(如果是空字符串用 ',')
	 * @param addBracket
	 *            是否添加中括号'[]'
	 */
	public static String buildCollection(Collection<?> colls, String separator, boolean addBracket) {
		StringBuilder build = new StringBuilder();
		if (addBracket) {
			build.append("[");
		}

		if (StringUtils.isEmpty(separator)) {
			separator = DEFAULT_SEPARATOR;
		}

		for (Object coll : colls) {
			build.append(coll.toString()).append(separator);
		}

		build.substring(0, build.lastIndexOf(separator));

		if (addBracket) {
			build.append("]");
		}

		String result = build.toString();
		System.out.println(result);
		return result;
	}

}
