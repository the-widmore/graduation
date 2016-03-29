package com.ccniit.graduation.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.qo.VoteQueryByCategory;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.Commons;
import com.ccniit.graduation.resource.VoteResource;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.DateUtils;

public class VoteServiceImplTest extends BaseTest {

	@Resource
	VoteService voteService;

	@Test
	public void testCreateVote() {
		Vote vote = new Vote("tableName", VoteResource.Category.info.toString(), 1, "title",
				DateUtils.getAfterDate(null, DateUtils.model_day, 20));
		long voteId = voteService.createVote(vote);
		assertNotEquals(0, voteId);
	}

	@Test
	public void testSelectVoteVo() {
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
