package com.ccniit.graduation.service;

import java.util.List;

import com.ccniit.graduation.pojo.db.VoterGroup;
import com.ccniit.graduation.pojo.vo.VoterGroupVo;

public interface VoterGroupService {

	long createVoterGroup(VoterGroup voterGroup);

	String getVoterGroupDescription(int voterGroupId);

	List<VoterGroupVo> getVoterGroups(long authorId);

	VoterGroup getVoterGroup(long voterGroupId);

}
