package com.ccniit.graduation.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ccniit.graduation.service.VoteSearchService;

@Controller
public class SearchController {

	@Resource
	VoteSearchService voteSearchService;

	private static final String SEARCH_VIEW_1 = "/search/";
	private static final String SEARCH_VIEW_2 = "/search/search.html";

	@RequestMapping(value = { SEARCH_VIEW_1, SEARCH_VIEW_2 }, method = RequestMethod.GET)
	public String searchPage(Object model) {
		return SEARCH_VIEW_2;
	}

	private static final String SEARCH_DO = "/search/searche.do";

	@RequestMapping(value = SEARCH_DO, method = RequestMethod.POST)
	public String search(@RequestParam("by") String by, @RequestParam("keyWords") String keyWords) {

		return SEARCH_VIEW_2;
	}

}
