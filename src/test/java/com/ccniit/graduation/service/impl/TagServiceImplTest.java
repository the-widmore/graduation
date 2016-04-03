package com.ccniit.graduation.service.impl;

import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.service.TagService;
import com.ccniit.graduation.util.StringUtils;

public class TagServiceImplTest extends BaseTest {

	@Resource
	TagService tagService;

	private static final String TEST_TAGS = "Not;yet;implemented";

	@Test
	public void testGetTagsId() {
		System.out.println(Arrays.toString(tagService.getTagsId(StringUtils.split(TEST_TAGS, ";"))));
	}

}
