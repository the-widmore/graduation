package com.ccniit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MoreController {

	protected static final String VIEW_MORE_ACTIVITY = "/more/activity.html";

	@RequestMapping(value = { VIEW_MORE_ACTIVITY }, method = RequestMethod.GET)
	public String activity(ModelMap modelMap) {

		return VIEW_MORE_ACTIVITY;
	}

	protected static final String USER_DATA_URL_AND_VIEW = "/more/userData.html";

	@RequestMapping(value = USER_DATA_URL_AND_VIEW, method = RequestMethod.GET)
	public String userData(Object model) {
		return USER_DATA_URL_AND_VIEW;
	}

	protected static final String PLATFORM_POLICY_URL_AND_VIEW = "/more/platformPolicy.html";

	@RequestMapping(value = PLATFORM_POLICY_URL_AND_VIEW, method = RequestMethod.GET)
	public String platformPolicy(Object model) {
		return PLATFORM_POLICY_URL_AND_VIEW;
	}

}
