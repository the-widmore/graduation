package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.service.VoteDateService;

public class VoteDateServiceImplTest extends BaseTest {

	@Resource
	VoteDateService voteDateService;

	@Test
	public void testStatisticsVoteData() throws IException {
		voteDateService.statisticsVoteData(47L);
	}

}
