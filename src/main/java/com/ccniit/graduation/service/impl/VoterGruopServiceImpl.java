package com.ccniit.graduation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.db.VoterGroup;
import com.ccniit.graduation.pojo.vo.VoterQuery;
import com.ccniit.graduation.service.VoterGruopService;

@Service("voterGruopService")
public class VoterGruopServiceImpl implements VoterGruopService {

	@Override
	public int createVoterGroup(VoterGroup voterGroup) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getVoterGroupDescription(int voterGroupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voter> getVotersByVoterGroupIdAndPage(VoterQuery voterQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getVoterGroups(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
