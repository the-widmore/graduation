package com.ccniit.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.builder.AuthorContentCounterBuilder;
import com.ccniit.graduation.dao.mysql.AuthorCountDao;
import com.ccniit.graduation.pojo.common.VoteCountByCategory;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;
import com.ccniit.graduation.resource.CacheNames;
import com.ccniit.graduation.service.AuthorContentCountService;
import com.ccniit.graduation.util.ShiroUtils;

@Service("authorCountService")
public class AuthorCountServiceImpl implements AuthorContentCountService {

	@Resource
	AuthorCountDao authorCountDao;
	@Resource
	AuthorContentCounterBuilder authorContentCounterBuilder;

	@Override
	public int countAuthorLinkmanGroup(long authorId) {
		return authorCountDao.countAuthorLinkmanGroup(authorId);
	}

	@Override
	public List<VoteCountByCategory> countAuthorVote(long authorId) {
		return authorCountDao.countAuthorVote(authorId);
	}

	@Cacheable(cacheNames = CacheNames.AUTHOR_VOTE_COUNT, key = "#authorId")
	@Override
	public AuthorContentCounter getAuthorCounters(long authorId) {
		return authorContentCounterBuilder.build(authorId);
	}

	@CacheEvict(cacheNames = CacheNames.AUTHOR_VOTE_COUNT, key = "#authorId")
	@Override
	public void updateAuthorContentCounter(long authorId) {
		AuthorContentCounter newAuthorContentCounter = getAuthorCounters(authorId);
		ShiroUtils.addAttribute("authorContentCounter", newAuthorContentCounter);
	}

}
