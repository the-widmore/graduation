package com.ccniit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelpController {

	protected static final String VIEW_HELP = "/help/help.html";

	@RequestMapping(value = VIEW_HELP, method = RequestMethod.GET)
	public String help() {

		return VIEW_HELP;
	}

	protected static final String VIEW_HELP_CONTACT_US = "/help/contactUs.html";

	@RequestMapping(value = { VIEW_HELP_CONTACT_US }, method = RequestMethod.GET)
	public String contactUs() {

		return VIEW_HELP_CONTACT_US;
	}

	protected static final String VIEW_HELP_CREATE_VOTE_FROM_FILE = "/help/createVoteFromFile.html";

	@RequestMapping(value = { VIEW_HELP_CREATE_VOTE_FROM_FILE }, method = RequestMethod.GET)
	public String createVoteFormFile() {
		return VIEW_HELP_CREATE_VOTE_FROM_FILE;
	}

	protected static final String VIEW_LINKMAN_FORMAT_ERROR = "/help/linkmanCreateFormate.html";

}
