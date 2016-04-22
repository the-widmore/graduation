package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.service.VoteTagService;

public class VoteTagServiceImplTest extends BaseTest {

	private static final String TAGS = "Tag1;;Tag2, Tag3 ;,; Tag4, Tag5;, tag6;,;";

	@Resource
	VoteTagService voteTagService;

	@Test
	public void testInsertTagToVote() {
		int result = voteTagService.insertTagToVote(1, TAGS);
		Assert.assertEquals(5, result);
	}

}
