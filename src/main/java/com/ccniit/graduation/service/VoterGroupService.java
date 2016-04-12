package com.ccniit.graduation.service;

import java.util.List;

import com.ccniit.graduation.pojo.db.VoterGroup;
import com.ccniit.graduation.pojo.vo.VoterGroupVo;

/**
 * 联系人组操作
 */
public interface VoterGroupService {
	/**
	 * 创建新的联系人
	 */
	long createVoterGroup(VoterGroup voterGroup);

	/**
	 * 获取联系人组的描述信息
	 */
	String getVoterGroupDescription(int voterGroupId);

	/**
	 * 获取Author所有的联系人组用于显示
	 */
	List<VoterGroupVo> getVoterGroups(long authorId);

	/**
	 * 获取一个联系人组
	 */
	VoterGroup getVoterGroup(long voterGroupId);

}
