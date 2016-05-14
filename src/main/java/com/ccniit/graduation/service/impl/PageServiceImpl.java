/**
* 
 */
package com.ccniit.graduation.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.pojo.common.PageInfo;
import com.ccniit.graduation.pojo.db.Vote.VoteCategory;
import com.ccniit.graduation.resource.CacheNames;
import com.ccniit.graduation.service.PageInfoService;

@Service("pageService")
public class PageServiceImpl implements PageInfoService {

	@Cacheable(cacheNames = CacheNames.PAGE_INFO,key="")
	@Override
	public PageInfo getVotePage(Long author, VoteCategory category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo getVoterPage(Long voterGroup) {
		// TODO Auto-generated method stub
		return null;
	}

}
