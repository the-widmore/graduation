package com.ccniit.graduation.builder;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ccniit.graduation.pojo.common.VoteCountByCategory;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;
import com.ccniit.graduation.resource.VoteResource;
import com.ccniit.graduation.service.AuthorCountService;

/**
 * 根据Author的Id构建AuthorContentCounter
 */
@Component("authorContentCounterBuilder")
public class AuthorContentCounterBuilder implements Builder<Long, AuthorContentCounter> {

	@Resource
	AuthorCountService authorCountService;

	@Override
	public AuthorContentCounter build(Long authorId) {
		List<VoteCountByCategory> voteCategoryCounts = authorCountService.countAuthorVote(authorId);

		int linkman = authorCountService.countAuthorLinkmanGroup(authorId);
		int vote = 0, poll = 0, info = 0;

		for (VoteCountByCategory voteCategoryCount : voteCategoryCounts) {
			String category = voteCategoryCount.getCategory();
			if (category.equals(VoteResource.VoteCategory.vote.toString())) {
				vote = voteCategoryCount.getCounter();
			} else if (category.equals(VoteResource.VoteCategory.poll.toString())) {
				poll = voteCategoryCount.getCounter();
			} else if (category.equals(VoteResource.VoteCategory.info.toString())) {
				info = voteCategoryCount.getCounter();
			}
		}

		AuthorContentCounter authorContentCounter = new AuthorContentCounter(authorId, linkman, vote, poll, info);
		return authorContentCounter;
	}

}
