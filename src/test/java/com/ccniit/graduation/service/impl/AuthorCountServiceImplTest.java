package com.ccniit.graduation.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.common.VoteCategoryCount;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;
import com.ccniit.graduation.service.AuthorCountService;

public class AuthorCountServiceImplTest extends BaseTest {

	@Resource
	AuthorCountService authorCountService;

	@Test
	public void testCountAuthorVote() {
		List<VoteCategoryCount> list1 = authorCountService.countAuthorVote(1);
		System.out.println(Arrays.toString(list1.toArray()));

		List<VoteCategoryCount> list = authorCountService.countAuthorVote(1);
		System.out.println(Arrays.toString(list.toArray()));
	}

	private static final int TEST_GET_TIMES = 10;

	@Test
	public void testGetAuthorCounters() {
		List<AuthorContentCounter> authorContentCounters = new ArrayList<>();
		for (int i = 0; i < TEST_GET_TIMES; i++) {
			authorContentCounters.add(authorCountService.getAuthorCounters(1));
		}

	}

}
