package com.ccniit.graduation.service;

public interface VoteTagService {

	/**
	 * 为一个投票插入Tag
	 * 
	 * @param tags
	 * @return inserted tag(Limit 5)
	 * 
	 */
	int insertTagToVote(String tags);

}
