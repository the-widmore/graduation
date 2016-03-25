package com.ccniit.graduation.dao.mysql;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.AuthorCountMapper;
import com.ccniit.graduation.pojo.common.VoteCategoryCount;

@Repository("authorCountDao")
public class AuthorCountDao implements AuthorCountMapper {

	@Resource
	AuthorCountMapper authorCountMapper;

	@Override
	public Integer countAuthorLinkmanGroup(long authorId) {
		return authorCountMapper.countAuthorLinkmanGroup(authorId);
	}

	@Override
	public List<VoteCategoryCount> countAuthorVote(long authorId) {
		return authorCountMapper.countAuthorVote(authorId);
	}

}
