package com.ccniit.graduation.service.impl;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.pojo.common.UserBaseInfo;
import com.ccniit.graduation.pojo.common.UserToken;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.service.AuthorService;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getShowName(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authorIsExist(Object email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Author findAuthorById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}