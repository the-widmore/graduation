package com.ccniit.graduation.service;

import java.util.List;

import com.ccniit.graduation.pojo.db.Voter;

public interface VoterService {

	long insertVoter(Voter voter);

	int insertVoters(List<Voter> voters);

	int deleteVoter(long voterId);

}
