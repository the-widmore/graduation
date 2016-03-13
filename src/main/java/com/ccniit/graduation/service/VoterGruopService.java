package com.ccniit.graduation.service;

import java.util.List;

import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.db.VoterGroup;
import com.ccniit.graduation.pojo.vo.VoterQuery;

public interface VoterGruopService {

	int createVoterGroup(VoterGroup voterGroup);

	String getVoterGroupDescription(int voterGroupId);

	List<Voter> getVotersByVoterGroupIdAndPage(VoterQuery voterQuery);

	Object getVoterGroups(long userId);

}
