package com.ccniit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MoreController {

	public static final String VIEW_MORE_ACTIVITY = "/more/activity.html";

	@RequestMapping(value = { VIEW_MORE_ACTIVITY }, method = RequestMethod.GET)
	public String activity(ModelMap modelMap) {

		return VIEW_MORE_ACTIVITY;
	}

}
