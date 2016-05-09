package com.ccniit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

	protected static final String NOT_FOUND = "/error/404";

	@RequestMapping(value = NOT_FOUND, method = RequestMethod.GET)
	public String notFound(ModelMap modelMap, Exception exception) {
		return NOT_FOUND;
	}

	protected static final String VOTE_NOT_FOUND = "/error/voteNotFound";

	@RequestMapping(value = VOTE_NOT_FOUND, method = RequestMethod.GET)
	public String voteNotFound(Exception exception) {
		return VOTE_NOT_FOUND;
	}

	protected static final String NOT_AUTH = "/error/403";

	@RequestMapping(value = NOT_AUTH, method = RequestMethod.GET)
	public String notAuth(ModelMap modelMap, Exception exception) {
		return NOT_AUTH;
	}

	protected static final String SERVER_ERROR = "/error/server";

	/**
	 * 服务器异常页面
	 */
	@RequestMapping(value = SERVER_ERROR, method = RequestMethod.GET)
	public String serverError(ModelMap modelMap, Exception exception) {
		return SERVER_ERROR;
	}

	protected static final String VIEW_USER_UNAUTHORIZED = "/error/userUnauthorized";

	/**
	 * 用户访问的资源没有授权错误页面
	 */
	@RequestMapping(value = { VIEW_USER_UNAUTHORIZED }, method = RequestMethod.GET)
	public String userUnauthorized(ModelMap modelMap) {

		return VIEW_USER_UNAUTHORIZED;
	}

}
