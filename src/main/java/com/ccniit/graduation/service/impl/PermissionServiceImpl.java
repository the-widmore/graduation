package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.ResourceDao;
import com.ccniit.graduation.resource.CacheNames;
import com.ccniit.graduation.service.PermissionService;

@Service("permissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {

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

	@Cacheable(cacheNames = CacheNames.AUTHOR_VOTE_COUNT, keyGenerator = "permissionCacheKeyGenerator")
	@Override
	public boolean havePermission(ResourceType type, long author, long resource) {
		boolean havePermission = false;
		switch (type) {
		case vote:
			havePermission = voteHavePermission(author, resource);
			break;
		case voter:
			havePermission = voterHavePermission(author, resource);
			break;
		case voterGroup:
			havePermission = voterGroupHavePermission(author, resource);
			break;
		default:
			break;
		}
		return havePermission;
	}

}
