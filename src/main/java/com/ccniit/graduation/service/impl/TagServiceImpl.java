package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccniit.graduation.dao.mysql.TagDao;
import com.ccniit.graduation.pojo.db.VoteTag;
import com.ccniit.graduation.service.TagService;

@Service("tagService")
public class TagServiceImpl implements TagService {

	@Resource
	TagDao tagDao;

	@Transactional
	@Override
	public Long insertTag(VoteTag voteTag) {
		return tagDao.insertTag(voteTag);
	}

	@Override
	public Long selectTag(String tag) {
		return tagDao.selectTagId(tag);
	}

	@Override
	public Long[] getTagsId(String[] tags) {
		int tagLength = tags.length;
		Long[] tagIds = new Long[tagLength];

		for (int i = 0; i < tagLength; i++) {
			String tag = tags[i];
			Long tagId = selectTag(tag);
			if (null == tagId || 0 == tagId) {
				tagId = insertTag(new VoteTag(tag));
			}
			tagIds[i] = tagId;
		}

		return tagIds;
	}

}
