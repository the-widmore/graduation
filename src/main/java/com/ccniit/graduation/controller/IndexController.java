package com.ccniit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	public static final String VIEW_INDEX = "../index";

	@RequestMapping(value = { "/", "index.jsp", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {

		return VIEW_INDEX;
	}

}
