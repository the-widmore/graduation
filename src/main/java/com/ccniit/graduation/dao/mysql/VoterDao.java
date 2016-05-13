package com.ccniit.graduation.dao.mysql;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.VoterMapper;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.qo.VoterQuery;

@Repository("voterDao")
public class VoterDao implements VoterMapper {

	@Resource
	VoterMapper voterMapper;

	@Override
	public Long insertVoter(Voter voter) {
		return voterMapper.insertVoter(voter);
	}

	@Override
	public Integer deleteVoter(long voterId) {
		return voterMapper.deleteVoter(voterId);
	}

	@Override
	public Integer updateVoter(Voter voter) {
		return voterMapper.updateVoter(voter);
	}

	@Override
	public Integer updateVoterAlias(long id, String alias) {
		return voterMapper.updateVoterAlias(id, alias);
	}

	@Override
	public Integer updateVoterEmail(long id, String email) {
		return voterMapper.updateVoterEmail(id, email);
	}

	@Override
	public Integer updateVoterPhone(long id, String phone) {
		return voterMapper.updateVoterPhone(id, phone);
	}

	@Override
	public List<Voter> selectVoterFromVoterGroup(VoterQuery voterQuery) {
		return voterMapper.selectVoterFromVoterGroup(voterQuery);
	}

	@Override
	public Voter selectVoteById(long voterId) {
		return voterMapper.selectVoteById(voterId);
	}

	@Override
	public Set<String> selectAllVoterEmailByVote(Long vote) {
		return voterMapper.selectAllVoterEmailByVote(vote);
	}

}
