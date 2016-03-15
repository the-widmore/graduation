package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.AuthorDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.vo.EmailToken;
import com.ccniit.graduation.service.AuthorAuthService;

@Service("authorAuthService")
public class AuthorAuthServiceImpl implements AuthorAuthService {

	private static final Logger LOG = LoggerFactory.getLogger(AuthorAuthServiceImpl.class);

	@Resource
	AuthorDao authorDao;

	@Override
	public boolean verifyByEmail(EmailToken token) throws IException {
		EmailToken realToken = authorDao.selectAuthorEmailToken(token.getEmail());

		if (realToken.getPassword().equals(token.getPassword())) {
			return true;
		}

		LOG.error("{} is error token!", token);

		return false;
	}

}
