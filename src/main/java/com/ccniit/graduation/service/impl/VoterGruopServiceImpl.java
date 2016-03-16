package com.ccniit.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.VoterGroupDao;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.db.VoterGroup;
import com.ccniit.graduation.pojo.qo.VoterQuery;
import com.ccniit.graduation.service.VoterGroupService;

@Service("voterGruopService")
public class VoterGruopServiceImpl implements VoterGroupService {

	@Resource
	VoterGroupDao voterGroupDao;

	@Override
	public long createVoterGroup(VoterGroup voterGroup) {
		return voterGroupDao.insertVoterGroup(voterGroup);
	}

	@Override
	public String getVoterGroupDescription(int voterGroupId) {
		return null;
	}

	@Override
	public List<Voter> getVotersByVoterGroupIdAndPage(VoterQuery voterQuery) {
		return null;
	}

	@Override
	public List<VoterGroup> getVoterGroups(long authorId) {
		return voterGroupDao.selectVoterGroups(authorId);
	}

	@Override
	public VoterGroup getVoterGroup(long voterGroupId) {
		// TODO Auto-generated method stub
		return null;
	}

}
