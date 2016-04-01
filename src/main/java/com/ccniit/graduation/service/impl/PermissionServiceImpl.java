package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.ResourceDao;
import com.ccniit.graduation.resource.CacheNames;
import com.ccniit.graduation.service.PermissionService;
import com.ccniit.graduation.util.LoggerUtils;

@Service("permissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {

	private static final Logger AUTH = LoggerUtils.getAuth();

	@Resource
	ResourceDao resourceDao;

	@Override
	public boolean voteHavePermission(long author, long vote) {
		Long owner = resourceDao.selectAuthorIdFromVote(vote);
		return chechPermission(author, vote, owner);
	}

	@Override
	public boolean voterHavePermission(long author, long voter) {
		Long owner = resourceDao.selectAuthorIdFromVoter(voter);
		return chechPermission(author, voter, owner);

	}

	@Override
	public boolean voterGroupHavePermission(long author, long voterGroup) {
		Long owner = resourceDao.selectAuthorIdFromVoterGroup(voterGroup);
		return chechPermission(author, voterGroup, owner);
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

	/**
	 * @param author
	 *            要判段的Author.id
	 * @param resource
	 *            资源id
	 * @param owner
	 *            资源的拥有者
	 */
	private boolean chechPermission(Long author, Long resource, Long owner) {
		if (null == resource || null == owner) {
			AUTH.warn("要查找的资源");
			return false;
		}

		if (author == owner) {
			return true;
		}
		return false;
	}

}
