package com.ccniit.graduation.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

	private static final String ARRAY_PREFIX = "[";
	private static final String ARRAY_POSTFIX = "]";
	private static final String ELEMENT_DIVIDER = ", ";

	public static <T> String listToString(List<T> list, String elementDivider) {

		int listSize = list.size();

		if (0 == listSize) {
			return StringUtils.EMPTY;
		}

		StringBuilder listCatStringBuilder = new StringBuilder();

		for (int i = 0; i < listSize; i++) {
			Object object = list.get(i);
			listCatStringBuilder.append(object).append(elementDivider);
		}

		int stringBuilderSize = listCatStringBuilder.length();
		listCatStringBuilder.delete(stringBuilderSize - elementDivider.length(), stringBuilderSize);

		return listCatStringBuilder.toString();
	}

	private static final String SEP1 = "#";
	private static final String SEP2 = "|";

	/**
	 * Map转换String
	 * 
	 * @param map
	 *            :需要转换的Map
	 * @return String转换后的字符串
	 */
	public static String MapToString(Map<?, ?> map) {
		StringBuffer sb = new StringBuffer();
		// 遍历map
		for (Object obj : map.keySet()) {
			if (obj == null) {
				continue;
			}
			Object key = obj;
			Object value = map.get(key);
			if (value instanceof List<?>) {
				sb.append(key.toString() + SEP1 + listToString((List<?>) value, ""));
				sb.append(SEP2);
			} else if (value instanceof Map<?, ?>) {
				sb.append(key.toString() + SEP1 + MapToString((Map<?, ?>) value));
				sb.append(SEP2);
			} else {
				sb.append(key.toString() + SEP1 + value.toString());
				sb.append(SEP2);
			}
		}
		return sb.toString();
	}

	public static <T> String collectionToString(Collection<T> colls, String elementDivider) {

		if (null == colls || 0 == colls.size()) {
			return StringUtils.EMPTY;
		}

		StringBuilder collectionToStringBuild = new StringBuilder();
		collectionToStringBuild.append(ARRAY_PREFIX);

		if (StringUtils.isEmpty(elementDivider) || StringUtils.isBlank(elementDivider)) {
			elementDivider = ELEMENT_DIVIDER;
		}

		Iterator<T> iterator = colls.iterator();
		while (iterator.hasNext()) {
			T t = iterator.next();
			collectionToStringBuild.append(t.toString()).append(elementDivider);
		}

		// delete last elementDivider
		int arrayToStringBuildLength = collectionToStringBuild.length();
		int elementDividerLength = elementDivider.length();
		collectionToStringBuild.delete(arrayToStringBuildLength - elementDividerLength, arrayToStringBuildLength);

		collectionToStringBuild.append(ARRAY_POSTFIX);

		return collectionToStringBuild.toString();

	}

	public static String arrayToString(Object[] objects, String elementDivider) {
		if (null == objects || 0 == objects.length) {
			return StringUtils.EMPTY;
		}

		StringBuilder arrayToStringBuild = new StringBuilder();
		arrayToStringBuild.append(ARRAY_PREFIX);

		if (null == elementDivider) {
			elementDivider = ELEMENT_DIVIDER;
		}

		for (int i = 0; i < objects.length; i++) {
			arrayToStringBuild.append(objects[i].toString()).append(elementDivider);
		}

		// delete last elementDivider
		int arrayToStringBuildLength = arrayToStringBuild.length();
		int elementDividerLength = elementDivider.length();
		arrayToStringBuild.delete(arrayToStringBuildLength - elementDividerLength, arrayToStringBuildLength);

		arrayToStringBuild.append(ARRAY_POSTFIX);

		return arrayToStringBuild.toString();
	}

	/**
	 * 对列表进行频率统计
	 * 
	 * @param <T>
	 *            统计对象的类型
	 * @param objects
	 *            对象列表
	 */
	public static <T> Map<T, Integer> frequency(List<T> objects) {
		Map<T, Integer> frequencyResule = new HashMap<>();

		for (int i = 0; i < objects.size(); i++) {
			T t = objects.get(i);

			if (frequencyResule.containsKey(t)) {
				frequencyResule.replace(t, frequencyResule.get(t) + 1);
			} else {
				frequencyResule.put(t, 1);
			}
		}

		return frequencyResule;
	}

	/**
	 * 
	 * */
	public static <T> Map<T, Integer> frequency(List<T> objects, Map<T, Integer> map) {
		for (int i = 0; i < objects.size(); i++) {
			T t = objects.get(i);

			if (map.containsKey(t)) {
				map.replace(t, map.get(t) + 1);
			} else {
				map.put(t, 1);
			}
		}
		return map;
	}

}
