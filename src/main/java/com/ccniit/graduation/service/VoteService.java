package com.ccniit.graduation.service;

import java.util.List;

import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.VoteResource;

public interface VoteService {

	Long createVote(Vote vote);

	List<VoteVo> selectVotes(long author, VoteResource.Category category, int page);

}
