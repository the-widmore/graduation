package com.ccniit.graduation.service;

import java.util.List;

/**
 * vote 搜索服务
 */
public interface VoteSearchService {

	public static enum SearchWay {
		/** 按照标题搜索 */
		TITLE,
		/** 按照标签搜索 */
		TAG,
		/** 按照内容搜索 */
		CONTENT
	}

	/**
	 * 按照搜索方式和关键字搜索
	 * 
	 * @return 搜索到的Vote的id列表
	 */
	public List<Long> search(SearchWay way, String keyWords);

	public List<Long> searchByTitle(String keyword);

	public List<Long> searchByTag(String keyword);

	public List<Long> searchByContent(String keyword);

}
