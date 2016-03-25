package com.ccniit.graduation.dao.mysql;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ccniit.graduation.mapper.VoteVoterGroupMapper;
import com.ccniit.graduation.pojo.db.VoteVoterGroup;

@Component("voteVoterGroupDao")
public class VoteVoterGroupDao implements VoteVoterGroupMapper {

	@Resource
	VoteVoterGroupMapper voteVoterGroupMapper;

	@Override
	public Integer insertVoteVoterGroup(VoteVoterGroup voteVoterGroup) {
		return voteVoterGroupMapper.insertVoteVoterGroup(voteVoterGroup);
	}

	@Override
	public List<Long> selectVoteGroupByVote(long vote) {
		// TODO Auto-generated method stub
		return null;
	}

}
