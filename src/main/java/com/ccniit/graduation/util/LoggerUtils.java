package com.ccniit.graduation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {

	private static final Logger DEV = LoggerFactory.getLogger("dev");
	private static final Logger AUTH = LoggerFactory.getLogger("auth");
	private static final Logger ERR = LoggerFactory.getLogger("err");
	private static final Logger BUS = LoggerFactory.getLogger("bus");

	/*** 开发日志 */
	public static Logger getDev() {
		return DEV;
	}

	/*** 授权日志 */
	public static Logger getAuth() {
		return AUTH;
	}

	/*** 错误日志 */
	public static Logger getErr() {
		return ERR;
	}

	/*** 业务 日志 */
	public static Logger getBus() {
		return BUS;
	}

}
