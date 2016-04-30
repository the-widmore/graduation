package com.ccniit.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.VoteVoterGroupDao;
import com.ccniit.graduation.pojo.db.VoteVoterGroup;
import com.ccniit.graduation.service.VoteVoterGroupService;

@Service("voteVoterGroupService")
public class VoteVoterGroupServiceImpl implements VoteVoterGroupService {

	@Resource
	VoteVoterGroupDao voteVoterGroupDao;

	@Override
	public Integer insertVoterGroups(Long voteId, Long[] voterGroups) {
		int inserted = 0;
		for (int i = 0; i < voterGroups.length; i++) {
			inserted += voteVoterGroupDao.insertVoteVoterGroup(new VoteVoterGroup(voteId, voterGroups[i]));
		}
		return inserted;
	}

	@Override
	public List<Long> selectVoteVoterGroups(Long voteId) {
		return voteVoterGroupDao.selectVoteGroupByVote(voteId);
	}

}
