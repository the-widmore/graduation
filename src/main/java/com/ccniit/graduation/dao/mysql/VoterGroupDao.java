package com.ccniit.graduation.dao.mysql;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.mapper.VoterGroupMapper;
import com.ccniit.graduation.pojo.db.VoterGroup;

@Service("voterGroupDao")
public class VoterGroupDao implements VoterGroupMapper {

	@Resource
	VoterGroupMapper voterGroupMapper;

	@Override
	public Long insertVoterGroup(VoterGroup voterGroup) {
		return voterGroupMapper.insertVoterGroup(voterGroup);
	}

	@Override
	public List<VoterGroup> selectVoterGroups(long authorId) {
		return voterGroupMapper.selectVoterGroups(authorId);
	}

	@Override
	public VoterGroup selectVoterGroup(long voterGroupId) {
		return voterGroupMapper.selectVoterGroup(voterGroupId);
	}

	@Override
	public Integer deleteVoterGroup(long voterGroupId) {
		return voterGroupMapper.deleteVoterGroup(voterGroupId);
	}

	@Override
	public Integer updateVoterGroupQuantity(long voterGroupId) {
		return voterGroupMapper.updateVoterGroupQuantity(voterGroupId);
	}

}
