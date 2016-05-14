package com.ccniit.graduation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.service.VoteSearchService;

@Service("voteSearchService")
public class VoteSearchServiceImpl implements VoteSearchService {

	@Override
	public List<Long> search(SearchWay way, String keyWords) {
		switch (way) {
		case TITLE:

			break;
		case TAG:

			break;
		case CONTENT:

			break;

		default:
			break;
		}

		return null;
	}

	@Override
	public List<Long> searchByTitle(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> searchByTag(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> searchByContent(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
