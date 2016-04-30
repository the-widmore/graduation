package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.AuthorInfoDao;
import com.ccniit.graduation.pojo.qo.AuthorSettingUpdater;
import com.ccniit.graduation.service.AuthorInfoService;

@Service("authorInfoService")
public class AuthorInfoServiceImpl implements AuthorInfoService {

	@Resource
	AuthorInfoDao authorInfoDao;

	@Override
	public Integer updateAuthorSetting(AuthorSettingUpdater updater) {
		return authorInfoDao.updateAuthorSetting(updater);
	}

}
