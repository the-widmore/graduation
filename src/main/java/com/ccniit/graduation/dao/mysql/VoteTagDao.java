package com.ccniit.graduation.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.VoteTagMapper;
import com.ccniit.graduation.pojo.db.VoteTag;
import com.ccniit.graduation.pojo.qo.VoteQuery;
import com.ccniit.graduation.pojo.vo.VoteVo;

@Repository("voteTagDao")
public class VoteTagDao implements VoteTagMapper {

	@Override
	public List<VoteTag> selectTop10Tags(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectTagId(String tag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertVoteTagByTagId(long vote, int tagId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertVoteTagByTagStr(long vote, String tag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> selectVoteTags(long vote) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VoteVo> selectVotes(VoteQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

}
