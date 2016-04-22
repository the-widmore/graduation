package com.ccniit.graduation.service;

import com.ccniit.graduation.pojo.db.VoteTag;

public interface TagService {

	Long insertTag(VoteTag voteTag);

	Long selectTag(String tag);

	Long[] getTagsId(String[] tags);

}
