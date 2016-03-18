package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.TagDao;
import com.ccniit.graduation.service.TagService;

@Service("tagService")
public class TagServiceImpl implements TagService {

	@Resource
	TagDao tagDao;

	@Override
	public int insertTagForVote(String tags) {
		// TODO impl
		return 0;
	}

}
