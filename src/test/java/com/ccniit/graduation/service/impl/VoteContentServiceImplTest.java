package com.ccniit.graduation.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.VoteContent;
import com.ccniit.graduation.service.VoteContentService;

public class VoteContentServiceImplTest extends BaseTest {

	@Resource
	VoteContentService voteContentService;

	@Ignore
	@Test
	public void testCreateVoteContent() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testLoadVoteContent() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetVoteContent() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdateVoteContent() throws IException {
		VoteContent content = new VoteContent(46L, "content");
		voteContentService.updateVoteContent(content);
	}

}
