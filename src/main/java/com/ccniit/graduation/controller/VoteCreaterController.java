package com.ccniit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VoteCreaterController {

	protected static final String VOTE_CREATE_BY_FILE_VIEW = "/vote/creater/file.html";
	protected static final String VIEW_CREATE_VOTE_FROM_FLIE = "/vote/createVoteFromFile.html";

	@RequestMapping(value = { VOTE_CREATE_BY_FILE_VIEW }, method = RequestMethod.GET)
	public String createVoteFromFile(ModelMap modelMap) {

		return VOTE_CREATE_BY_FILE_VIEW;
	}

	@RequestMapping(value = "path", method = RequestMethod.GET)
	public String get(Object model) {
		// TODO Auto generated method stub
		return null;
	}

	protected static final String VOTE_CREATE_BY_FILE_DO = "";

}
