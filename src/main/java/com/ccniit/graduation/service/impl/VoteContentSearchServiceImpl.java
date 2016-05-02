package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.service.VoteContentSearchService;
import com.ccniit.graduation.service.VoteContentService;

@Service("voteContentSearchService")
public class VoteContentSearchServiceImpl implements VoteContentSearchService {

	@Resource
	VoteContentService voteContentService;

	@Override
	public void addVoteContentToIndex(long vote) {

	}

}
