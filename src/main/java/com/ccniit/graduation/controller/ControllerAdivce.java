package com.ccniit.graduation.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ccniit.graduation.exception.NotLoginException;

@ControllerAdvice(basePackages = "com.ccniit.graduation.controller")
public class ControllerAdivce {

	@ExceptionHandler(NotLoginException.class)
	public String redirectToLoginUrl() {
		return UserController.VIEW_USER_LOGIN;
	}

}
