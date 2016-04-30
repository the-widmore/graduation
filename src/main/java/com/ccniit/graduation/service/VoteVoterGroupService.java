package com.ccniit.graduation.service;

import java.util.List;

public interface VoteVoterGroupService {

	Integer insertVoterGroups(Long voteId, Long[] voterGroups);

	List<Long> selectVoteVoterGroups(Long voteId);

}
