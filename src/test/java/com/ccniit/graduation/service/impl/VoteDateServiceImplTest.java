package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.service.VoteDataService;

public class VoteDateServiceImplTest extends BaseTest {

	@Resource
	VoteDataService VoteDataService;

	@Test
	public void testStatisticsVoteData() throws IException {
		VoteDataService.statisticsVoteData(47L);
	}

	@Test
	public void testToC3Pie() throws IException {

		for (int i = 1; i < 4; i++) {
			VoteDataService.toC3Pie(47L, i);
		}
	}

}
