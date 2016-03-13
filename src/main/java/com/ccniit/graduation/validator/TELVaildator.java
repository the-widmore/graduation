package com.ccniit.graduation.validator;

public class TELVaildator implements StringVaildator {

	private static String TEL_REGEX = "";// TODO 手机正则表达式

	@Override
	public boolean chech(String source) {
		return source.matches(TEL_REGEX);
	}

}
