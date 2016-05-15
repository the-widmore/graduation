package com.ccniit.graduation.service;

import com.ccniit.graduation.pojo.db.AuthorInfo;
import com.ccniit.graduation.pojo.qo.AuthorInfoUpdater;
import com.ccniit.graduation.pojo.qo.AuthorSettingUpdater;

public interface AuthorInfoService {

	Integer insertEmptyAuthorInfo(Long author);

	Integer updateAuthorInfo(AuthorInfoUpdater updater);

	Integer updateAuthorSetting(AuthorSettingUpdater updater);

	AuthorInfo selectAuthorInfo(Long author);

}
