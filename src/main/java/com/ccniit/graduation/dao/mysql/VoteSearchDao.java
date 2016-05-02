package com.ccniit.graduation.dao.mysql;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.VoteSearchMapper;
import com.ccniit.graduation.pojo.qo.VoteQueryByTag;
import com.ccniit.graduation.pojo.qo.VoteQueryByTitle;

@Repository("voteSearchDao")
public class VoteSearchDao implements VoteSearchMapper {

	@Resource
	VoteSearchMapper voteSearchMapper;

	@Override
	public List<Long> selectVoteByTitle(VoteQueryByTitle voteQueryByTitle) {
		return voteSearchMapper.selectVoteByTitle(voteQueryByTitle);
	}

	@Override
	public List<Long> selectVoteByTag(VoteQueryByTag voteQueryByTag) {
		return voteSearchMapper.selectVoteByTag(voteQueryByTag);
	}

}
