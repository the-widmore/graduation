package com.ccniit.graduation.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.convertor.VoterGroupToVoterGroupVo;
import com.ccniit.graduation.dao.mysql.VoterGroupDao;
import com.ccniit.graduation.pojo.db.VoterGroup;
import com.ccniit.graduation.pojo.vo.VoterGroupVo;
import com.ccniit.graduation.service.VoterGroupService;

@Service("voterGruopService")
public class VoterGruopServiceImpl implements VoterGroupService {

	@Resource
	VoterGroupDao voterGroupDao;
	@Resource
	VoterGroupToVoterGroupVo voterGroupToVoterGroupVo;

	@Override
	public long createVoterGroup(VoterGroup voterGroup) {
		return voterGroupDao.insertVoterGroup(voterGroup);
	}

	@Override
	public String getVoterGroupDescription(int voterGroupId) {
		return null;
	}

	@Override
	public List<VoterGroupVo> getVoterGroups(long authorId) {
		List<VoterGroup> voterGroups = voterGroupDao.selectVoterGroups(authorId);
		List<VoterGroupVo> voterGroupVos = new ArrayList<>();
		for (VoterGroup voterGroup : voterGroups) {
			voterGroupVos.add(voterGroupToVoterGroupVo.convert(voterGroup));
		}
		return voterGroupVos;
	}

	@Override
	public VoterGroup getVoterGroup(long voterGroupId) {
		// TODO Auto-generated method stub
		return null;
	}

}
