package com.ccniit.graduation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {

	private static final Logger DEV = LoggerFactory.getLogger("dev");
	private static final Logger AUTH = LoggerFactory.getLogger("auth");
	private static final Logger ERR = LoggerFactory.getLogger("err");

	public static Logger getDev() {
		return DEV;
	}

	public static Logger getAuth() {
		return AUTH;
	}

	public static Logger getErr() {
		return ERR;
	}

}
