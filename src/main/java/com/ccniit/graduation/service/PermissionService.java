package com.ccniit.graduation.service;

/**
 * 提供权限的检查接口（vote,voter,voterGroup）
 */
public interface PermissionService {

	public static enum ResourceType {
		vote, voter, voterGroup
	}

	boolean voteHavePermission(long author, long vote);

	boolean voterHavePermission(long author, long voter);

	boolean voterGroupHavePermission(long author, long voterGroup);

	boolean havePermission(ResourceType type, long author, long resource);

}
