package com.ccniit.graduation.service.impl;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.vo.VoteVo;
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
	public void testSelectVotes() {
		List<VoteVo> voteVos1 = voteService.selectVotes(1, VoteResource.Category.info, 1);
		System.out.println(Arrays.deepToString(voteVos1.toArray()));
		List<VoteVo> voteVos2 = voteService.selectVotes(1, VoteResource.Category.info, 1);
		System.out.println(Arrays.deepToString(voteVos2.toArray()));
		List<VoteVo> voteVos3 = voteService.selectVotes(1, VoteResource.Category.info, 1);
		System.out.println(Arrays.deepToString(voteVos3.toArray()));
	}

}
