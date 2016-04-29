package com.ccniit.graduation.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ccniit.graduation.exception.AuthorNotFoundException;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.util.SpringMVCUtils;

@ControllerAdvice(basePackages = "com.ccniit.graduation.controller")
public class ControllerAdivce {

	private static final String ERROR_MESSAGE_KEY = "errorMessage";

	/**
	 * 捕获最定义异常
	 */
	@ExceptionHandler(IException.class)
	public String handleException(IException exception, ModelMap modelMap) {
		String errorPage = null;
		switch (exception.getCode()) {
		case AuthorNotFoundException.AUTHOR_NOT_FOUND_EXCEPTION_CODE:
			errorPage = UserController.VIEW_USER_LOGIN;
			break;

		default:
			break;
		}

		modelMap.addAttribute(ERROR_MESSAGE_KEY, exception.getMessage());
		return SpringMVCUtils.redirect(errorPage);
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception) {

		return null;
	}

}
