package com.ccniit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {

	protected static final String SEARCH_TAG = "search/tag";

	@RequestMapping(value = SEARCH_TAG, method = RequestMethod.GET)
	public String searchByTag(Object model) {

		return SEARCH_TAG;
	}

}
