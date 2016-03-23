package com.ccniit.graduation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {

	// 开发日志
	private static final Logger DEV = LoggerFactory.getLogger("dev");
	// 授权日志
	private static final Logger AUTH = LoggerFactory.getLogger("auth");
	// 错误日志
	private static final Logger ERR = LoggerFactory.getLogger("err");
	// 业务 日志
	private static final Logger BUS = LoggerFactory.getLogger("bus");

	public static Logger getDev() {
		return DEV;
	}

	public static Logger getAuth() {
		return AUTH;
	}

	public static Logger getErr() {
		return ERR;
	}

	public static Logger getBus() {
		return BUS;
	}

}
