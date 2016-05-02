package com.ccniit.graduation.service.impl;

import java.text.MessageFormat;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.ResourceDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.ParamsException;
import com.ccniit.graduation.exception.PermissionException;
import com.ccniit.graduation.resource.CacheNames;
import com.ccniit.graduation.service.PermissionService;
import com.ccniit.graduation.util.LoggerUtils;

@Service("permissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {

	private static final Logger AUTH = LoggerUtils.getAuth();

	@Resource
	ResourceDao resourceDao;

	@Override
	public boolean voteHavePermission(Long author, Long vote) {
		Long owner = resourceDao.selectAuthorIdFromVote(vote);
		return chechPermission(author, vote, owner);
	}

	@Override
	public boolean voterHavePermission(Long author, Long voter) {
		Long owner = resourceDao.selectAuthorIdFromVoter(voter);
		return chechPermission(author, voter, owner);

	}

	@Override
	public boolean voterGroupHavePermission(Long author, Long voterGroup) {
		Long owner = resourceDao.selectAuthorIdFromVoterGroup(voterGroup);
		return chechPermission(author, voterGroup, owner);
	}

	private static final String NO_PERMISSION_MESSAGE_TEMPLATE = "用户id为{0}，没有访问资源类型是{1}的id为{2}资源!";

	@Cacheable(cacheNames = CacheNames.AUTHOR_VOTE_COUNT, keyGenerator = "permissionCacheKeyGenerator")
	@Override
	public boolean havePermission(ResourceType type, Long author, Long resource) throws IException {

		if (null == type || null == author || null == resource) {
			throw new ParamsException("参数type,author,resource不能有空值！");
		}

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
		if (!havePermission) {
			String noPermissionMessage = MessageFormat.format(NO_PERMISSION_MESSAGE_TEMPLATE, author, type.toString(),
					resource);
			AUTH.warn(noPermissionMessage);
			throw new PermissionException(noPermissionMessage);
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
			return false;
		}

		if (author.longValue() == owner.longValue()) {
			return true;
		}
		return false;
	}

}
