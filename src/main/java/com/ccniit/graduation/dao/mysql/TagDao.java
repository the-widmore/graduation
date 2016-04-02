package com.ccniit.graduation.dao.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.TagMapper;
import com.ccniit.graduation.pojo.db.VoteTag;

@Repository("tagDao")
public class TagDao implements TagMapper {

	@Resource
	TagMapper tagMapper;

	@Override
	public Long insertTag(VoteTag voteTag) {
		tagMapper.insertTag(voteTag);
		return voteTag.getId();
	}

	@Override
	public Long selectTagId(String tag) {
		return tagMapper.selectTagId(tag);
	}

}
