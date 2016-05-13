package com.ccniit.graduation.builder;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ccniit.graduation.pojo.common.VoteCountByCategory;
import com.ccniit.graduation.pojo.db.Vote.VoteCategory;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;
import com.ccniit.graduation.service.AuthorContentCountService;

/**
 * 根据Author的Id构建AuthorContentCounter
 */
@Component("authorContentCounterBuilder")
public class AuthorContentCounterBuilder implements Builder<Long, AuthorContentCounter> {

	@Resource
	AuthorContentCountService authorCountService;

	@Override
	public AuthorContentCounter build(Long authorId) {
		List<VoteCountByCategory> voteCategoryCounts = authorCountService.countAuthorVote(authorId);

		int linkman = authorCountService.countAuthorLinkmanGroup(authorId);
		int vote = 0;
		int poll = 0;
		int info = 0;

		for (VoteCountByCategory voteCategoryCount : voteCategoryCounts) {
			VoteCategory category = VoteCategory.valueOf(voteCategoryCount.getCategory());

			switch (category) {
			case vote:
				vote = voteCategoryCount.getCounter();
				break;
			case poll:
				poll = voteCategoryCount.getCounter();
				break;
			case info:
				info = voteCategoryCount.getCounter();
				break;
			default:
				break;
			}

		}

		AuthorContentCounter authorContentCounter = new AuthorContentCounter(authorId, linkman, vote, poll, info);
		return authorContentCounter;
	}

}
