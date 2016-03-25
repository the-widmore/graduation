package com.ccniit.graduation.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.convertor.VoteToVoteVo;
import com.ccniit.graduation.dao.mysql.VoteDao;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.qo.BaseQuery;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.CacheNams;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.service.VoteTagService;

@Service("voteService")
public class VoteServiceImpl implements VoteService {

	@Resource
	VoteDao voteDao;
	@Resource
	VoteTagService voteTagService;
	@Resource
	VoteToVoteVo voteToVoteVo;

	@Override
	public Long createVote(Vote vote) {
		return voteDao.insertVote(vote);
	}

	@Cacheable(cacheNames = CacheNams.VOTE, key = "#voteId")
	@Override
	public VoteVo selectVoteVo(long voteId) {
		Vote vote = voteDao.selectVoteById(voteId);
		return voteToVoteVo.convert(vote);
	}

	@Override
	public List<VoteVo> selectVoteVos(BaseQuery query) {
		List<Long> voteIds = voteDao.selectAuthorVotesId(query);
		List<VoteVo> voteVos = new ArrayList<>(voteIds.size());
		for (Long voteId : voteIds) {
			voteVos.add(selectVoteVo(voteId));
		}
		return voteVos;
	}

}
