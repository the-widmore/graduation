package com.ccniit.graduation.dao.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.ResourceMapper;

@Repository("resourceDao")
public class ResourceDao implements ResourceMapper {

	@Resource
	ResourceMapper resourceMapper;

	@Override
	public Long selectAuthorIdFromVote(long voteId) {
		return resourceMapper.selectAuthorIdFromVote(voteId);
	}

	@Override
	public Long selectAuthorIdFromVoterGroup(long voterGroupId) {
		return resourceMapper.selectAuthorIdFromVoterGroup(voterGroupId);
	}

	@Override
	public Long selectAuthorIdFromVoter(long voterId) {
		return resourceMapper.selectAuthorIdFromVoter(voterId);
	}

}
