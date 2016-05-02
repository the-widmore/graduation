package com.ccniit.graduation.service;

import java.util.List;

/**
 * vote 搜索服务
 */
public interface VoteSearchService {

	public static enum SearchWay {
		TITLE, TAG, CONTENT
	}

	/**
	 * 按照搜索方式和关键字搜索
	 * 
	 * @return 搜索到的Vote的id列表
	 */
	public List<Long> search(SearchWay way, String keyWords);

}
