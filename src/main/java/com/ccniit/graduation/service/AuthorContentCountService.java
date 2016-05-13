package com.ccniit.graduation.service;

import java.util.List;

import com.ccniit.graduation.pojo.common.VoteCountByCategory;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;

/**
 * 内容计数器，包括(联系人组，Vote(vote,poll,info))
 */
public interface AuthorContentCountService {

	int countAuthorLinkmanGroup(long authorId);

	List<VoteCountByCategory> countAuthorVote(long authorId);

	AuthorContentCounter getAuthorCounters(long authorId);

	/**
	 * 更新计数器Cache，同时更新Session value
	 */
	void updateAuthorContentCounter(long authorId);

}
