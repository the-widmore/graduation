package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.VoteContentDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.VoteContent;
import com.ccniit.graduation.service.VoteContentService;
import com.ccniit.graduation.validator.ObjectFieldNullChecher;

@Service("voteContentService")
public class VoteContentServiceImpl implements VoteContentService {

	@Resource
	private VoteContentDao voteContentDao;
	@Resource
	private ObjectFieldNullChecher objectFieldNullChecher;

	@Override
	public Long createVoteContent(VoteContent content) {
		return voteContentDao.insertVoteContent(content);
	}

	@Override
	public String loadVoteContent(long voteId) {
		return voteContentDao.selectVoteContent(voteId);
	}

	@Override
	public VoteContent getVoteContent(long voteId) {
		return new VoteContent(voteId, loadVoteContent(voteId));
	}

	@Override
	public void updateVoteContent(VoteContent content) throws IException {

		objectFieldNullChecher.check(content, "id");

		voteContentDao.updateVoteContent(content);
	}

}
