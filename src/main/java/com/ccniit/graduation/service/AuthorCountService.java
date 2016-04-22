package com.ccniit.graduation.service;

import java.util.List;

import com.ccniit.graduation.pojo.common.VoteCountByCategory;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;

public interface AuthorCountService {

	int countAuthorLinkmanGroup(long authorId);

	List<VoteCountByCategory> countAuthorVote(long authorId);

	AuthorContentCounter getAuthorCounters(long authorId);

}
