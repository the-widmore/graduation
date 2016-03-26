package com.ccniit.graduation.dao.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.AuthorInfoMapper;
import com.ccniit.graduation.pojo.db.AuthorInfo;
import com.ccniit.graduation.pojo.qo.AuthorUpdater;

@Repository("authorInfoDao")
public class AuthorInfoDao implements AuthorInfoMapper {

	@Resource
	AuthorInfoMapper authorInfoMapper;

	@Override
	public Integer insertEmptyAuthorInfo(long author) {
		return authorInfoMapper.insertEmptyAuthorInfo(author);
	}

	@Override
	public Integer updateAuthorInfo(AuthorUpdater authorUpdater) {
		return authorInfoMapper.updateAuthorInfo(authorUpdater);
	}

	@Override
	public AuthorInfo selectAuthorInfo(long author) {
		return authorInfoMapper.selectAuthorInfo(author);
	}

}
