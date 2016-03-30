package com.ccniit.graduation.service;

import java.util.List;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.qo.PagedQuery;
import com.ccniit.graduation.pojo.qo.VoteCreater;
import com.ccniit.graduation.pojo.vo.VoteVo;

public interface VoteService {

	/**
	 * 创建一个新的投票
	 * 
	 * @throws IException
	 */
	Long createVote(VoteCreater creater) throws IException;

	/**
	 * 使用直接的方式创建
	 */
	Long createVote(Vote vote);

	/**
	 * 查询一个Vote,使用缓存
	 * 
	 * @param Vote.id
	 * @return VoteVo(use VoteToVoteVo)
	 * 
	 * @throws IException
	 */
	VoteVo selectVoteVo(long vote) throws IException;

	/**
	 * 使用VoteQuery查询Votes,使用selectVoteVo方法
	 * 
	 * @param VoteQuery
	 * @return List<VoteVo>
	 */
	List<VoteVo> selectVoteVos(PagedQuery query);

}
