package com.ccniit.graduation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.ccniit.graduation.pojo.db.VoteVoterGroup;

/**
 * Vote使用的VoterGroup，Vote一对多VoterGroup
 */
public interface VoteVoterGroupMapper {

	/**
	 * 
	 * @param
	 * @return
	 */
	@Insert("INSERT INTO vote_voter_group(vote,voterGroup) VALUES(#{vote},#{voterGroup})")
	Integer insertVoteVoterGroup(VoteVoterGroup voteVoterGroup);

	/**
	 * 
	 * @param
	 * @return
	 */
	// TODO
	List<Long> selectVoteGroupByVote(long vote);

}
