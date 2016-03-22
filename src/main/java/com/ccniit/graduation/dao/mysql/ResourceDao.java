package com.ccniit.graduation.dao.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.ResourceMapper;

@Repository("resourceDao")
public class ResourceDao implements ResourceMapper {

	@Resource
	ResourceMapper resourceMapper;

	@Override
	public long selectAuthorIdFromVote(long voteId) {
		return resourceMapper.selectAuthorIdFromVote(voteId);
	}

	@Override
	public long selectAuthorIdFromVoterGroup(long voterGroupId) {
		return resourceMapper.selectAuthorIdFromVoterGroup(voterGroupId);
	}

	@Override
	public long selectAuthorIdFromVoter(long voterId) {
		return resourceMapper.selectAuthorIdFromVoter(voterId);
	}

}
