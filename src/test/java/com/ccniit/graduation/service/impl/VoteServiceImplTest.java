package com.ccniit.graduation.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.qo.VoteCreater;
import com.ccniit.graduation.pojo.qo.VoteQueryByCategory;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.Commons;
import com.ccniit.graduation.resource.VoteResource;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.DateUtils;
import com.ccniit.graduation.util.LoggerUtils;

public class VoteServiceImplTest extends BaseTest {

	private static final Logger DEV = LoggerUtils.getDev();

	@Resource
	VoteService voteService;

	@Test
	public void testCreateVoteByVote() {
		Vote vote = new Vote("tableName", VoteResource.VoteCategory.info.toString(), 1, "title",
				DateUtils.getAfterDate(null, DateUtils.MODEL_DAY, 20));
		long voteId = voteService.createVote(vote);
		assertNotEquals(0, voteId);
	}

	@Test
	@Transactional(rollbackFor = RuntimeException.class)
	public void testCreateVoteByVoteCreater() throws IException {
		VoteCreater creater = new VoteCreater();
		creater.setAuthor(1L);
		creater.setTags("Tag1;;Tag2, Tag3 ;,; Tag4, Tag5;, tag6;,;");
		creater.setTitle("vote title");

		long voteId = voteService.createVote(creater);
		DEV.debug(voteId + "");

		Assert.assertNotEquals(0, voteId);
	}

	@Test
	public void testSelectVoteVo() throws IException {
		VoteVo voteVo = voteService.selectVoteVo(1);
		assertEquals(10, voteVo.getProgress());
	}

	@Test
	public void testSelectVoteVos() {
		VoteQueryByCategory query = new VoteQueryByCategory(1L, "info");
		query.setPageSize(Commons.VOTE_PAGE_SIZE);
		query.setOffset(Commons.VOTE_PAGE_SIZE * 0);
		List<VoteVo> voteVos1 = voteService.selectVoteVos(query);
		List<VoteVo> voteVos2 = voteService.selectVoteVos(query);
		List<VoteVo> voteVos3 = voteService.selectVoteVos(query);
		System.out.println(Arrays.toString(voteVos1.toArray()));
		System.out.println(Arrays.toString(voteVos2.toArray()));
		System.out.println(Arrays.toString(voteVos3.toArray()));
	}

}
