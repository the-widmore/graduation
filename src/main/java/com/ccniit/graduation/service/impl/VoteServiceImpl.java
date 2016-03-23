package com.ccniit.graduation.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.convertor.VoteToVoteVo;
import com.ccniit.graduation.dao.mysql.VoteDao;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.CacheNams;
import com.ccniit.graduation.resource.VoteResource;
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

	@Cacheable(cacheNames = CacheNams.VOTE, key = "#author+#category.toString()")
	@Override
	public List<VoteVo> selectVotes(long author, VoteResource.Category category, int page) {

		List<Vote> votes = voteDao.selectAuthorVotes(author, category, page);
		List<VoteVo> voteVos = new ArrayList<>(votes.size());

		for (Vote vote : votes) {
			voteVos.add(voteToVoteVo.convert(vote));
		}

		return voteVos;
	}

}
