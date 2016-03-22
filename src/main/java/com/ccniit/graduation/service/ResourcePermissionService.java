package com.ccniit.graduation.service;

public interface ResourcePermissionService {

	boolean voteHavePermission(long author, long vote);

	boolean voterHavePermission(long author, long voter);

	boolean voterGroupHavePermission(long author, long voterGroup);

}
