package com.ccniit.graduation.dao.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.AuthorInfoMapper;
import com.ccniit.graduation.pojo.db.AuthorInfo;
import com.ccniit.graduation.pojo.qo.AuthorConfigUpdater;
import com.ccniit.graduation.pojo.qo.AuthorInfoUpdater;

@Repository("authorInfoDao")
public class AuthorInfoDao implements AuthorInfoMapper {

	@Resource
	AuthorInfoMapper authorInfoMapper;

	@Override
	public Integer insertEmptyAuthorInfo(long author) {
		return authorInfoMapper.insertEmptyAuthorInfo(author);
	}

	@Override
	public Integer updateAuthorInfo(AuthorInfoUpdater updater) {
		return authorInfoMapper.updateAuthorInfo(updater);
	}

	@Override
	public AuthorInfo selectAuthorInfo(long author) {
		return authorInfoMapper.selectAuthorInfo(author);
	}

	@Override
	public Integer updateAuthorConfig(AuthorConfigUpdater updater) {
		// TODO Auto-generated method stub
		return null;
	}

}
