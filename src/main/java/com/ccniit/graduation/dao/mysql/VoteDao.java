package com.ccniit.graduation.dao.mysql;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.VoteMapper;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.VoteCategory;

@Repository("voteDao")
public class VoteDao implements VoteMapper {

	@Resource
	VoteMapper voteMapper;

	@Override
	public long insertVote(Vote vote) {
		return voteMapper.insertVote(vote);
	}

	@Override
	public int updateVoteProgress(long vote, int progress) {
		return voteMapper.updateVoteProgress(vote, progress);
	}

	@Override
	public int updateVoteEndDate(long vote, Date enDate) {
		return voteMapper.updateVoteEndDate(vote, enDate);
	}

	@Override
	public Vote selectVoteById(long vote) {
		return voteMapper.selectVoteById(vote);
	}

	@Override
	public Vote selectVoteByTableName(String tableName) {
		return voteMapper.selectVoteByTableName(tableName);
	}

	@Override
	public List<VoteVo> selectAuthorVotes(long author, VoteCategory category) {
		return voteMapper.selectAuthorVotes(author, category);
	}

}