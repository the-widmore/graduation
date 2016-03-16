package com.ccniit.graduation.service;

import java.util.List;

import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.db.VoterGroup;
import com.ccniit.graduation.pojo.vo.VoterQuery;

public interface VoterGroupService {

	long createVoterGroup(VoterGroup voterGroup);

	String getVoterGroupDescription(int voterGroupId);

	List<Voter> getVotersByVoterGroupIdAndPage(VoterQuery voterQuery);

	List<VoterGroup> getVoterGroups(long authorId);

	VoterGroup getVoterGroup(long voterGroupId);

}
