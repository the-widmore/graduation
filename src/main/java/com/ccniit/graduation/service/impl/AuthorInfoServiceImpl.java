package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.AuthorInfoDao;
import com.ccniit.graduation.pojo.qo.AuthorConfigUpdater;
import com.ccniit.graduation.service.AuthorInfoService;

@Service("authorInfoService")
public class AuthorInfoServiceImpl implements AuthorInfoService {

	@Resource
	AuthorInfoDao authorInfoDao;
	
	@Override
	public Integer updateAuthorConfig(AuthorConfigUpdater updater) {
		// TODO Auto-generated method stub
		return null;
	}

}
