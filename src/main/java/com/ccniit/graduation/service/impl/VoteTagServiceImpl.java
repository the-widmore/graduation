package com.ccniit.graduation.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccniit.graduation.dao.mysql.VoteTagDao;
import com.ccniit.graduation.resource.CacheNames;
import com.ccniit.graduation.service.TagService;
import com.ccniit.graduation.service.VoteTagService;
import com.ccniit.graduation.util.LoggerUtils;
import com.ccniit.graduation.util.StringUtils;

@Service("voteTagService")
public class VoteTagServiceImpl implements VoteTagService {

	private static final Logger DEV = LoggerUtils.getDev();

	// Vote标签使用';'OR','分割
	private static final String TAG_DIVISION = "[;|,]+";

	@Resource
	VoteTagDao voteTagDao;
	@Resource
	TagService tagService;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public int insertTagToVote(long vote, String tags) {
		String[] tagArray = StringUtils.split(tags, TAG_DIVISION);
		String[] newTags = Arrays.copyOfRange(tagArray, 0, 5);
		int inserted = 0;

		Long[] tagIds = tagService.getTagsId(newTags);
		for (int i = 0; i < newTags.length; i++) {
			inserted += voteTagDao.insertVoteTagByTagId(vote, tagIds[i]);
		}

		DEV.debug("vote:{} tags:{}", vote, Arrays.toString(tagIds));

		return inserted;
	}

	@Override
	public String selectTagsToString(long vote) {
		return voteTagDao.selectVoteTagsToString(vote);
	}

	@Cacheable(cacheNames = CacheNames.VOTE_TAG, key = "#vote")
	@Override
	public List<String> selectTagsToArray(long vote) {
		return voteTagDao.selectVoteTagsToArray(vote);
	}

}
