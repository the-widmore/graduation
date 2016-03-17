package com.ccniit.graduation.dao.mysql;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.VoteTagMapper;
import com.ccniit.graduation.pojo.qo.VoteQuery;
import com.ccniit.graduation.pojo.vo.VoteVo;

@Repository("voteTagDao")
public class VoteTagDao implements VoteTagMapper {

	@Resource
	VoteTagMapper voteTagMapper;

	@Override
	public int insertVoteTag(String tag, long vote) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<VoteVo> selectVotes(VoteQuery query) {
		return voteTagMapper.selectVotes(query);
	}

	@Override
	public String selectVoteTag(long vote) {
		// TODO Auto-generated method stub
		return null;
	}

}
