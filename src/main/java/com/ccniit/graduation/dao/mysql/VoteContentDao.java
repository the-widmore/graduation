package com.ccniit.graduation.dao.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.VoteContentMapper;
import com.ccniit.graduation.pojo.db.VoteContent;

@Repository("voteContentDao")
public class VoteContentDao implements VoteContentMapper {

	@Resource
	VoteContentMapper voteContentMapper;

	@Override
	public Long insertVoteContent(VoteContent content) {
		voteContentMapper.insertVoteContent(content);
		return content.getId();
	}

	@Override
	public Integer updateVoteContent(VoteContent newContent) {
		return voteContentMapper.updateVoteContent(newContent);
	}

}
