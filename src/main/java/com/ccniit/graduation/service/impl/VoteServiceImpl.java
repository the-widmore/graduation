package com.ccniit.graduation.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccniit.graduation.convertor.VoteToVoteVo;
import com.ccniit.graduation.dao.mysql.VoteDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.ServerException;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.qo.PagedQuery;
import com.ccniit.graduation.pojo.qo.VoteCreater;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.CacheNames;
import com.ccniit.graduation.resource.VoteResource;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.service.VoteTagService;
import com.ccniit.graduation.util.LoggerUtils;
import com.ccniit.graduation.util.StringUtils;

@Service("voteService")
public class VoteServiceImpl implements VoteService {

	private static final Logger DEV = LoggerUtils.getDev();

	@Resource
	VoteDao voteDao;
	@Resource
	VoteTagService voteTagService;
	@Resource
	VoteToVoteVo voteToVoteVo;

	@Override
	public Long createVote(Vote vote) {
		voteDao.insertVote(vote);
		return vote.getId();
	}

	@Transactional(propagation = Propagation.NESTED)
	@Override
	public Long createVote(VoteCreater creater) throws IException {
		Vote vote = new Vote();

		// from create
		vote.setAuthor(creater.getAuthor());
		vote.setTitle(creater.getTitle());

		// random and unique value
		vote.setTableName(StringUtils._getUUID());
		vote.setCategory(VoteResource.Category.vote.toString());

		// other default value(inDate,progress,auth)

		Long voteId = createVote(vote);
		if (0 == voteId) {
			throw new ServerException("insert vote error");
		}

		String tags = creater.getTags();
		if (org.apache.commons.lang.StringUtils.isNotBlank(tags)) {
			voteTagService.insertTagToVote(voteId, tags);
		}

		return voteId;
	}

	@Cacheable(cacheNames = CacheNames.VOTE, key = "#voteId")
	@Override
	public VoteVo selectVoteVo(long voteId) {
		Vote vote = voteDao.selectVoteById(voteId);

		DEV.debug("{}:{}", voteId, vote);

		return voteToVoteVo.convert(vote);
	}

	@Override
	public List<VoteVo> selectVoteVos(PagedQuery query) {
		List<Long> voteIds = voteDao.selectAuthorVotesId(query);
		List<VoteVo> voteVos = new ArrayList<>(voteIds.size());
		for (Long voteId : voteIds) {
			voteVos.add(selectVoteVo(voteId));
		}
		return voteVos;
	}

}
