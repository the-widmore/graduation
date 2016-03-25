package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.AuthorDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.vo.EmailToken;
import com.ccniit.graduation.service.AuthorAuthService;
import com.ccniit.graduation.util.LoggerUtils;

@Service("authorAuthService")
public class AuthorAuthServiceImpl implements AuthorAuthService {

	private static final Logger LOG = LoggerUtils.getAuth();

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
