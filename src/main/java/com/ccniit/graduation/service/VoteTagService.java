package com.ccniit.graduation.service;

import java.util.List;

public interface VoteTagService {

	/**
	 * 为一个投票插入Tag
	 * 
	 * @param tags
	 * @return inserted tag(Limit 5)
	 * 
	 */
	int insertTagToVote(long vote, String tags);

	/**
	 * 获取Vote的全部Tag,使用空格连接
	 * 
	 * @param Vote.id
	 * @return tags
	 */
	String selectTagsToString(long vote);

	/**
	 * 获取数组类型的Vote标签
	 */
	List<String> selectTagsToArray(long vote);

}
