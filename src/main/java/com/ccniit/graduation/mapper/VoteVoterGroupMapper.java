package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Insert;

import com.ccniit.graduation.pojo.db.VoteVoterGroup;

/**
 * Vote使用的VoterGroup，Vote一对多VoterGroup
 */
public interface VoteVoterGroupMapper {

	@Insert("INSERT INTO vote_voter_group(vote,voterGroup) VALUES(#{vote},#{voterGroup})")
	int insertVoteVoterGroup(VoteVoterGroup voteVoterGroup);

}
