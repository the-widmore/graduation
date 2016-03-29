package com.ccniit.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.VoterDao;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.db.Voter.VoterField;
import com.ccniit.graduation.pojo.qo.VoterQuery;
import com.ccniit.graduation.resource.CacheNams;
import com.ccniit.graduation.service.VoterService;

@Service("voterService")
public class VoterServiceImpl implements VoterService {

	@Resource
	VoterDao voterDao;

	@Override
	public long insertVoter(Voter voter) {
		return voterDao.insertVoter(voter);
	}

	@Override
	public int insertVoters(List<Voter> voters) {
		int successInsertRecode = 0;

		for (Voter voter : voters) {
			voter.setVoterGroupId(1);
			long voterId = insertVoter(voter);
			if (0 < voterId) {
				successInsertRecode += 1;
			}
		}

		return successInsertRecode;
	}

	@Cacheable(cacheNames = CacheNams.VOTER, key = "#voterId")
	@Override
	public int deleteVoter(long voterId) {
		return voterDao.deleteVoter(voterId);
	}

	@Override
	public List<Voter> selectVoterFromVoterGroup(VoterQuery voterQuery) {
		return voterDao.selectVoterFromVoterGroup(voterQuery);
	}

	@Override
	public Voter getVoter(long voterId) {
		return voterDao.selectVoteById(voterId);
	}

	@Override
	public String getVoterField(VoterField field, long voterId) {
		Voter voter = getVoter(voterId);
		String value = null;
		switch (field) {
		case email:
			value = voter.getEmail();
			break;
		case phone:
			value = voter.getPhone();
			break;
		case alias:
			value = voter.getAlias();
			break;
		}
		return value;
	}

	@CacheEvict(cacheNames = CacheNams.VOTER, key = "#voterId")
	@Override
	public String updateVoterField(VoterField field, long voterId) {

		switch (field) {
		case email:
			voterDao.updateVoterEmail(voterId);
			break;
		case phone:
			voterDao.updateVoterPhone(voterId);
			break;
		case alias:
			voterDao.updateVoterAlias(voterId);
			break;
		default:
			break;
		}
		return getVoterField(field, voterId);
	}

}
