package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.ResourceDao;
import com.ccniit.graduation.service.ResourcePermissionService;

@Service("resourcePermissionService")
public class ResourcePermissionServiceImpl implements ResourcePermissionService {

	@Resource
	ResourceDao resourceDao;

	@Override
	public boolean voteHavePermission(long author, long vote) {
		if (author == resourceDao.selectAuthorIdFromVote(vote)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean voterHavePermission(long author, long voter) {
		if (author == resourceDao.selectAuthorIdFromVoter(voter)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean voterGroupHavePermission(long author, long voterGroup) {
		if (author == resourceDao.selectAuthorIdFromVoterGroup(voterGroup)) {
			return true;
		}
		return false;
	}

}
