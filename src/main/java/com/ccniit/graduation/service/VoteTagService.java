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
	 * 
	 * 
	 * */
	String selectTagsToString(long vote);

	List<String> selectTagsToArray(long vote);

}
