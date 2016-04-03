package com.ccniit.graduation.service;

import com.ccniit.graduation.pojo.db.VoteContent;

public interface VoteContentService {

	Long createVoteContent(VoteContent content);

	/**
	 * 加载投票的内容
	 * 
	 * @param 投票的id
	 * @return 投票的问题定义
	 */
	String loadVoteContent(long voteId);

	VoteContent getVoteContent(long voteId);

	/**
	 * 更新问题定义
	 */
	Integer updateVoteContent(VoteContent content);

}
