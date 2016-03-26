package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.builder.AuthorContentCounterBuilder;
import com.ccniit.graduation.dao.mysql.AuthorDao;
import com.ccniit.graduation.pojo.common.UserToken;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.qo.AuthorUpdater;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;
import com.ccniit.graduation.resource.CacheNams;
import com.ccniit.graduation.service.AuthorService;
import com.ccniit.graduation.util.LoggerUtils;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	private static final Logger BUS_LOG = LoggerUtils.getBus();

	@Resource
	AuthorContentCounterBuilder authorContentCounterBuilder;
	@Resource
	AuthorDao authorDao;

	@Override
	public long register(Author author) {
		BUS_LOG.info("", author.getEmail());
		return 0;
	}

	@Override
	public boolean authentication(UserToken userToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateAuthorBase(AuthorUpdater authorUpdater) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAuthorInfo(AuthorUpdater authorUpdater) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getAuthorIdByEmail(String email) {
		return authorDao.selectAuthorIdByEmail(email);
	}

	@Override
	public boolean authorIsExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Cacheable(cacheNames = CacheNams.AUTHOR, key = "#authorId")
	@Override
	public Author findAuthorById(long authorId) {
		return authorDao.selectById(authorId);
	}

	@Cacheable(cacheNames = CacheNams.AUTHOR_VOTE_COUNT, key = "#authorId")
	@Override
	public AuthorContentCounter getAuthorContentCounter(long authorId) {
		return authorContentCounterBuilder.build(authorId);
	}

}
