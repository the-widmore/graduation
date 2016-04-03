package com.ccniit.graduation.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.service.VoteContentService;

public class VoteContentServiceImplTest extends BaseTest {

	@Resource
	VoteContentService voteContentService;

	@Test
	public void testCreateVoteContent() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadVoteContent() {
		System.out.println("VoteContent:" + voteContentService.loadVoteContent(1));
	}

	@Test
	public void testUpdateVoteContent() {
		fail("Not yet implemented");
	}

}
