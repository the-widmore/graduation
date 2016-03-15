package com.ccniit.graduation.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.common.VoteCategoryCount;
import com.ccniit.graduation.service.AuthorCountService;

public class AuthorCountServiceImplTest extends BaseTest {

	@Resource
	AuthorCountService authorCountService;

	@Test
	public void testCountAuthorVote() {
		List<VoteCategoryCount> list = authorCountService.countAuthorVote(1);
		System.out.println(Arrays.toString(list.toArray()));
		List<VoteCategoryCount> list1 = authorCountService.countAuthorVote(1);
		System.out.println(Arrays.toString(list1.toArray()));
		List<VoteCategoryCount> list2 = authorCountService.countAuthorVote(1);
		System.out.println(Arrays.toString(list2.toArray()));
		List<VoteCategoryCount> list3 = authorCountService.countAuthorVote(1);
		System.out.println(Arrays.toString(list3.toArray()));
	}

}
