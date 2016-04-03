package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.service.VoteContentSearchService;

public class VoteContentSearchServiceImplTest extends BaseTest {

	@Resource
	VoteContentSearchService voteContentSearchService;

	@Test
	public void testAddVoteContentToIndex() {
		voteContentSearchService.addVoteContentToIndex(1);
	}

}
