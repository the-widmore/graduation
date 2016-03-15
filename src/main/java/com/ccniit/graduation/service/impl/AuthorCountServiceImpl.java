package com.ccniit.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.AuthorCountDao;
import com.ccniit.graduation.pojo.common.VoteCategoryCount;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;
import com.ccniit.graduation.resource.CacheNams;
import com.ccniit.graduation.service.AuthorCountService;

@Service("authorCountService")
public class AuthorCountServiceImpl implements AuthorCountService {

	@Resource
	AuthorCountDao authorCountDao;

	@Override
	public List<VoteCategoryCount> countAuthorVote(long authorId) {
		return authorCountDao.countAuthorVote(authorId);
	}

	@Cacheable(cacheNames = CacheNams.AUTHOR_VOTE_COUNT, key = "#authorId")
	@Override
	public AuthorContentCounter getAuthorAuthorContentCounter(long authorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
