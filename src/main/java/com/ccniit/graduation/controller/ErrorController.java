package com.ccniit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

	public static final String NOT_FOUND = "/error/404";

	@RequestMapping(value = NOT_FOUND, method = RequestMethod.GET)
	public String notFound(Object model) {
		return NOT_FOUND;
	}

}
