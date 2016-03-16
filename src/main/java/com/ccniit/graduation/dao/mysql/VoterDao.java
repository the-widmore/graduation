package com.ccniit.graduation.dao.mysql;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.VoterMapper;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.vo.VoterQuery;

@Repository("voteDao")
public class VoterDao implements VoterMapper {

	@Resource
	VoterMapper voterMapper;

	@Override
	public long insertVoter(Voter voter) {
		return voterMapper.insertVoter(voter);
	}

	@Override
	public int deleteVoter(long voterId) {
		return voterMapper.deleteVoter(voterId);
	}

	@Override
	public int updateVoter(Voter voter) {
		return voterMapper.updateVoter(voter);
	}

	@Override
	public List<Voter> selectVoterFromVoterGroup(VoterQuery voterQuery) {
		return voterMapper.selectVoterFromVoterGroup(voterQuery);
	}

}
