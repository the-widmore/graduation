package com.ccniit.graduation.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccniit.graduation.convertor.VoteToVoteVo;
import com.ccniit.graduation.dao.mysql.VoteDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.ServerException;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.db.Vote.AuthType;
import com.ccniit.graduation.pojo.db.VoteContent;
import com.ccniit.graduation.pojo.qo.PagedQuery;
import com.ccniit.graduation.pojo.qo.VoteCreater;
import com.ccniit.graduation.pojo.qo.VotePublishVo;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.CacheNames;
import com.ccniit.graduation.resource.VoteResource;
import com.ccniit.graduation.service.VoteContentService;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.service.VoteTagService;
import com.ccniit.graduation.util.StringUtils;

@Service("voteService")
public class VoteServiceImpl implements VoteService {

	@Resource
	private VoteDao voteDao;
	@Resource
	private VoteTagService voteTagService;
	@Resource
	private VoteToVoteVo voteToVoteVo;
	@Resource
	private VoteContentService voteContentService;

	@Override
	public Long createVote(Vote vote) {
		voteDao.insertVote(vote);
		Long voteId = vote.getId();
		voteContentService.createVoteContent(new VoteContent(voteId));
		return voteId;
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
		vote.setCategory(VoteResource.VoteCategory.vote.toString());

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
	public Vote selectVote(long voteId) throws IException {
		return voteDao.selectVoteById(voteId);
	}

	@Cacheable(cacheNames = CacheNames.VOTE_VO, key = "#voteId")
	@Override
	public VoteVo selectVoteVo(long voteId) throws IException {
		Vote vote = selectVote(voteId);
		VoteVo voteVo = voteToVoteVo.convert(vote);
		return voteVo;
	}

	@Override
	public List<VoteVo> selectVoteVos(PagedQuery query) throws IException {
		List<Long> voteIds = voteDao.selectAuthorVotesId(query);
		List<VoteVo> voteVos = new ArrayList<>(voteIds.size());
		for (Long voteId : voteIds) {
			VoteVo vo = selectVoteVo(voteId);
			voteVos.add(vo);
		}
		return voteVos;
	}

	@Override
	public Integer updateVoteByPublish(VotePublishVo publishVo) {
		Long vote = publishVo.getVoteId();
		voteDao.updateVotePredictDate(vote, publishVo.getEndDate());
		voteDao.updateVoteProgress(vote, VoteResource.PUBLISTED);
		return voteDao.updateVoteAuthType(vote, AuthType.valueOf(publishVo.getAuthType()));
	}

}
