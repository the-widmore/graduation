package com.ccniit.graduation.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.TagDao;
import com.ccniit.graduation.dao.mysql.VoteTagDao;
import com.ccniit.graduation.pojo.db.VoteTag;
import com.ccniit.graduation.service.VoteTagService;
import com.ccniit.graduation.util.LoggerUtils;
import com.ccniit.graduation.util.StringUtils;

@Service("voteTagService")
public class VoteTagServiceImpl implements VoteTagService {

	private static final Logger DEV_LOG = LoggerUtils.getDev();

	// Vote标签使用';'OR','分割
	private static final String TAG_DIVISION = "[;|,]+";

	@Resource
	VoteTagDao voteTagDao;
	@Resource
	TagDao tagDao;

	@Override
	public int insertTagToVote(long vote, String tags) {
		String[] tagArray = StringUtils.split(tags, TAG_DIVISION);
		String[] newTags = Arrays.copyOfRange(tagArray, 0, 5);
		int inserted = 0;
		for (int i = 0; i < newTags.length; i++) {
			Long tagId = selectTagId(newTags[i]);
			inserted += voteTagDao.insertVoteTagByTagId(vote, tagId);
		}
		return inserted;
	}

	@Override
	public String selectTagsToString(long vote) {
		return voteTagDao.selectVoteTagsToString(vote);
	}

	@Override
	public List<String> selectTagsToArray(long vote) {
		return voteTagDao.selectVoteTagsToArray(vote);
	}

	// 查询tag的id,没有就插入,并返回id
	private Long selectTagId(String tag) {

		DEV_LOG.debug(tag);

		Long id = tagDao.selectTagId(tag);
		if (null == id || 0 == id) {
			return tagDao.insertTag(new VoteTag(tag));
		} else {
			return id;
		}

	}

}
