package com.ccniit.graduation.dao.mysql;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.VoteMapper;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.qo.PagedQuery;

@Repository("voteDao")
public class VoteDao implements VoteMapper {

	@Resource
	private VoteMapper voteMapper;

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
	public Integer updateVoteToPublish(Date predictDate, String auth, int progress, String url, long id) {
		return voteMapper.updateVoteToPublish(predictDate, auth, progress, url, id);
	}

	@Override
	public Integer updateVoteToEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateVoteEndDate(long vote, Date enDate) {
		return voteMapper.updateVoteEndDate(vote, enDate);
	}

	@Override
	public Vote selectVoteById(long vote) {
		return voteMapper.selectVoteById(vote);
	}

	@Override
	public Long selectVoteIdByTableName(String tableName) {
		return voteMapper.selectVoteIdByTableName(tableName);
	}

	@Override
	public Long selectVoteIdByUrl(String url) {
		return voteMapper.selectVoteIdByUrl(url);
	}

	@Override
	public String selectVoteTableName(long vote) {
		return voteMapper.selectVoteTableName(vote);
	}

	@Override
	public List<Long> selectAuthorVotesId(PagedQuery query) {
		return voteMapper.selectAuthorVotesId(query);
	}

}
