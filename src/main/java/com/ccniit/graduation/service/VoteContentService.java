package com.ccniit.graduation.service;

import com.ccniit.graduation.pojo.db.VoteContent;

/**
 * Vote的问题相关接口
 */
public interface VoteContentService {

	Long createVoteContent(VoteContent content);

	/**
	 * 加载投票的内容
	 * 
	 * @param 投票的id
	 * @return 投票的问题定义
	 */
	String loadVoteContent(long voteId);

	/**
	 * 获取Vote定义的问题 加载投票的内容
	 * 
	 * @param 投票的id
	 * @return 投票的问题定义
	 */
	VoteContent getVoteContent(long voteId);

	/**
	 * 更新问题定义
	 */
	Integer updateVoteContent(VoteContent content);

}
