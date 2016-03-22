package com.ccniit.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.VoterDao;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.qo.VoterQuery;
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

	@Override
	public int deleteVoter(long voterId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Voter> selectVoterFromVoterGroup(VoterQuery voterQuery) {
		return voterDao.selectVoterFromVoterGroup(voterQuery);
	}

}
