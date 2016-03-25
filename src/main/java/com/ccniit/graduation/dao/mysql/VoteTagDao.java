package com.ccniit.graduation.dao.mysql;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.VoteTagMapper;
import com.ccniit.graduation.pojo.db.VoteTag;
import com.ccniit.graduation.pojo.qo.VoteQueryTag;

@Repository("voteTagDao")
public class VoteTagDao implements VoteTagMapper {

	@Resource
	VoteTagMapper voteTagMapper;

	@Override
	public List<VoteTag> selectTop10Tags(String tag) {
		return voteTagMapper.selectTop10Tags(tag);
	}

	@Override
	public Integer selectTagId(String tag) {
		return voteTagMapper.selectTagId(tag);
	}

	@Override
	public Integer insertVoteTagByTagId(long vote, int tagId) {
		return voteTagMapper.insertVoteTagByTagId(vote, tagId);
	}

	@Override
	public Integer insertVoteTagByTagStr(long vote, String tag) {
		return voteTagMapper.insertVoteTagByTagStr(vote, tag);
	}

	@Override
	public String selectVoteTagsToString(long vote) {
		return voteTagMapper.selectVoteTagsToString(vote);
	}

	@Override
	public List<String> selectVoteTagsToArray(long vote) {
		return voteTagMapper.selectVoteTagsToArray(vote);
	}

	@Override
	public List<Long> selectVotesIdByTag(VoteQueryTag query) {
		return voteTagMapper.selectVotesIdByTag(query);
	}

}
