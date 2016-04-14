package com.ccniit.graduation.dao.mysql;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.VoteMapper;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.db.Vote.AuthType;
import com.ccniit.graduation.pojo.qo.PagedQuery;
import com.ccniit.graduation.pojo.vo.VoteSearchResult;

@Repository("voteDao")
public class VoteDao implements VoteMapper {

	@Resource
	VoteMapper voteMapper;

	@Override
	public Long insertVote(Vote vote) {
		voteMapper.insertVote(vote);
		return vote.getId();
	}

	@Override
	public Integer updateVoteProgress(long vote, int progress) {
		return voteMapper.updateVoteProgress(vote, progress);
	}

	@Override
	public Integer updateVotePredictDate(long vote, Date predictDate) {
		return voteMapper.updateVotePredictDate(vote, predictDate);
	}

	@Override
	public Integer updateVoteEndDate(long vote, Date enDate) {
		return voteMapper.updateVoteEndDate(vote, enDate);
	}

	@Override
	public Integer updateVoteAuthType(long vote, AuthType authType) {
		return voteMapper.updateVoteAuthType(vote, authType);
	}

	@Override
	public Vote selectVoteById(long vote) {
		return voteMapper.selectVoteById(vote);
	}

	@Override
	public Long selectVoteByTableName(String tableName) {
		return voteMapper.selectVoteByTableName(tableName);
	}

	@Override
	public String selectVoteTableName(long vote) {
		return voteMapper.selectVoteTableName(vote);
	}

	@Override
	public Long selectVoteByUrl(String url) {
		return voteMapper.selectVoteByUrl(url);
	}

	@Override
	public List<Long> selectAuthorVotesId(PagedQuery query) {
		return voteMapper.selectAuthorVotesId(query);
	}

	@Override
	public List<VoteSearchResult> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
