package com.ccniit.graduation.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.service.VoteTagService;
import com.ccniit.graduation.util.CollectionUtils;
import com.ccniit.graduation.util.StringUtils;

@Service("voteTagService")
public class VoteTagServiceImpl implements VoteTagService {

	private static final String TAG_DIVISION = "[;|,\\s]+";

	@Override
	public int insertTagToVote(String tags) {
		String[] tagArray = StringUtils.split(tags, TAG_DIVISION);
		List<String> tagsList = CollectionUtils.partition(Arrays.asList(tagArray), 0, 5);
		// TODO

		return 0;
	}

}
