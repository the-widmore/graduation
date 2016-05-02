package com.ccniit.graduation.service;

import com.ccniit.graduation.exception.IException;

/**
 * 提供权限的检查接口（vote,voter,voterGroup）
 */
public interface PermissionService {

	public static enum ResourceType {
		vote, voter, voterGroup
	}

	boolean voteHavePermission(Long author, Long vote);

	boolean voterHavePermission(Long author, Long voter);

	boolean voterGroupHavePermission(Long author, Long voterGroup);

	boolean havePermission(ResourceType type, Long author, Long resource) throws IException;

}
