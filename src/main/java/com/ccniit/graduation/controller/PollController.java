package com.ccniit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PollController {

	protected static final String VIEW_POLL = "/poll/startPoll.html";

	@RequestMapping(value = { VIEW_POLL }, method = RequestMethod.GET)
	public String poll(ModelMap modelMap) {

		return VIEW_POLL;
	}

	protected static final String VIEW_POII_CREATE_POLL = "/poll/createPoll.html";

	@RequestMapping(value = { VIEW_POII_CREATE_POLL }, method = RequestMethod.GET)
	public String createPoll(ModelMap modelMap) {

		return VIEW_POII_CREATE_POLL;
	}

}
