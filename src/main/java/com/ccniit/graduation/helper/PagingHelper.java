package com.ccniit.graduation.helper;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于分页
 */
public class PagingHelper {

	private static final Logger LOG = LoggerFactory.getLogger(PagingHelper.class);

	private static final String PAGE_ITEM = "<li><a href=\"#url\">#page</a></li>";

	public static String buildPagingHTML(Paging paging) {
		int counter = paging.getCounter();

		if (null == paging || 0 == counter) {
			LOG.warn("paging is null or empty");
			return StringUtils.EMPTY;
		}

		StringBuilder builder = new StringBuilder();
		builder.append("<ul class=\"pagination\">");
		if (counter <= 5) {
			for (int i = 1; i < counter; i++) {

			}
		}

		return builder.toString();
	}

}
