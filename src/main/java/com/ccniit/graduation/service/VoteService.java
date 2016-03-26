package com.ccniit.graduation.service;

import java.util.List;

import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.qo.PagedQuery;
import com.ccniit.graduation.pojo.vo.VoteVo;

public interface VoteService {

	Long createVote(Vote vote);

	/**
	 * 查询一个Vote,使用缓存
	 * 
	 * @param Vote.id
	 * @return VoteVo(use VoteToVoteVo)
	 */
	VoteVo selectVoteVo(long vote);

	/**
	 * 使用VoteQuery查询Votes,使用selectVoteVo方法
	 * 
	 * @param VoteQuery
	 * @return List<VoteVo>
	 */
	List<VoteVo> selectVoteVos(PagedQuery query);

}
