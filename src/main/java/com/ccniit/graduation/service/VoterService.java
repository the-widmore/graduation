package com.ccniit.graduation.service;

import java.util.List;
import java.util.Set;

import com.ccniit.graduation.pojo.common.Page;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.qo.VoterQuery;

public interface VoterService {

	long insertVoter(Voter voter);

	int insertVoters(List<Voter> voters);

	int deleteVoter(long voterId);

	List<Voter> selectVoterFromVoterGroup(VoterQuery voterQuery);

	List<Voter> selectVoterFromVoterGroup(Page page, Long author, Long voterGroup);

	Voter getVoter(long voterId);

	String getVoterField(Voter.VoterField field, long voterId);

	String updateVoterField(Voter.VoterField field, long voterId, String value);

	Set<String> distinctVoteVoter(Long vote);

}
