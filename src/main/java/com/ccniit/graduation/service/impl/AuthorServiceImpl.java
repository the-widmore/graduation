package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.builder.AuthorContentCounterBuilder;
import com.ccniit.graduation.dao.mysql.AuthorDao;
import com.ccniit.graduation.pojo.common.UserBaseInfo;
import com.ccniit.graduation.pojo.common.UserToken;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;
import com.ccniit.graduation.resource.CacheNams;
import com.ccniit.graduation.service.AuthorService;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	@Resource
	AuthorContentCounterBuilder authorContentCounterBuilder;
	@Resource
	AuthorDao authorDao;

	@Override
	public long register(Author author) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean authentication(UserToken userToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateBaseInfo(UserBaseInfo userBaseInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getAuthorIdByEmail(String email) {
		return authorDao.selectAuthorIdByEmail(email);
	}

	@Override
	public String getShowName(Long id) {
		Author author = findAuthorById(id);
		String nickname = author.getNickname().trim();
		if (StringUtils.isNotBlank(nickname)) {
			return nickname;
		} else {
			String email = author.getEmail();
			return email.split("@")[0];
		}
	}

	@Override
	public boolean authorIsExist(Object email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Cacheable(cacheNames = CacheNams.AUTHOR, key = "#id")
	@Override
	public Author findAuthorById(long id) {
		return authorDao.selectById(id);
	}

	@Cacheable(cacheNames = CacheNams.AUTHOR_VOTE_COUNT, key = "#authorId")
	@Override
	public AuthorContentCounter getAuthorContentCounter(long authorId) {
		return authorContentCounterBuilder.build(authorId);
	}

}
