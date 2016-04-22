package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.plus.lucene.VoteIndex;
import com.ccniit.graduation.pojo.db.VoteContent;
import com.ccniit.graduation.service.VoteContentSearchService;
import com.ccniit.graduation.service.VoteContentService;

@Service("voteContentSearchService")
public class VoteContentSearchServiceImpl implements VoteContentSearchService {

	@Resource
	VoteContentService voteContentService;
	@Resource
	VoteIndex voteIndex;

	@Override
	public void addVoteContentToIndex(long vote) {
		VoteContent voteContent = voteContentService.getVoteContent(vote);

		voteIndex.addVoteToIndex(voteContent);
	}

}
