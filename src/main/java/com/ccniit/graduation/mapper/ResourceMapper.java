package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Select;

public interface ResourceMapper {

	@Select("SELECT author FROM vote WHERE id=#{voteId}")
	Long selectAuthorIdFromVote(long voteId);

	@Select("SELECT author FROM voter_group WHERE id=#{voterGroupId}")
	Long selectAuthorIdFromVoterGroup(long voterGroupId);

	@Select("SELECT author FROM voter_group WHERE id=(SELECT voterGroup FROM voter WHERE id=#{voterId})")
	Long selectAuthorIdFromVoter(long voterId);

}
