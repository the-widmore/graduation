package com.ccniit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {

	protected static final String VIEW_ABOUT = "/about/about.html";

	@RequestMapping(value = { VIEW_ABOUT }, method = RequestMethod.GET)
	public String about(ModelMap modelMap) {

		return VIEW_ABOUT;
	}

	protected static final String VIEW_ABOUT_ALIAS = "/about/aboutAlias.html";

	@RequestMapping(value = { VIEW_ABOUT_ALIAS }, method = RequestMethod.GET)
	public String aboutAlias(ModelMap modelMap) {

		return VIEW_ABOUT_ALIAS;
	}

	protected static final String VIEW_ABOUT_DATA_SAVE = "/about/dataSave.html";

	@RequestMapping(value = { VIEW_ABOUT_DATA_SAVE }, method = RequestMethod.GET)
	public String aboutDataSave(ModelMap modelMap) {

		return VIEW_ABOUT_DATA_SAVE;
	}

	protected static final String VIEW_ABOUT_SECOND_PASSWORD = "/about/secondPassword.html";

	@RequestMapping(value = { VIEW_ABOUT_SECOND_PASSWORD }, method = RequestMethod.GET)
	public String aboutSecondPassword(ModelMap modelMap) {

		return VIEW_ABOUT_SECOND_PASSWORD;
	}

	protected static final String VIEW_ABOUT_SYSTEM_SECURITY = "/about/systemSecurity.html";

	@RequestMapping(value = { VIEW_ABOUT_SYSTEM_SECURITY }, method = RequestMethod.GET)
	public String systemSecurity(ModelMap modelMap) {

		return VIEW_ABOUT_SYSTEM_SECURITY;
	}

}
