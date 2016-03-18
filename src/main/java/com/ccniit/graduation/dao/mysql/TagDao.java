package com.ccniit.graduation.dao.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.TagMapper;

@Repository("tagDao")
public class TagDao implements TagMapper {

	@Resource
	TagMapper tagMapper;

	@Override
	public int countTag(String tag) {
		return tagMapper.countTag(tag);
	}

	@Override
	public int insertTag(String tag) {
		return tagMapper.insertTag(tag);
	}

}
