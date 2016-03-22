package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Select;

public interface ResourceMapper {

	@Select("SELECT author FROM vote WHERE id=#{voteId}")
	long selectAuthorIdFromVote(long voteId);

	@Select("SELECT author FROM voter_group WHERE id=#{voterGroupId}")
	long selectAuthorIdFromVoterGroup(long voterGroupId);

	@Select("SELECT author FROM voter_group WHERE (SELECT voterGroup FROM voter WHERE id=#{voterId})")
	long selectAuthorIdFromVoter(long voterId);

}
