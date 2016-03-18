package com.ccniit.graduation.validator;

public class TELVaildator implements StringVaildator {

	private static String TEL_REGEX = "^1[3|4|5|8]\\d{9}$";

	@Override
	public boolean chech(String source) {
		return source.matches(TEL_REGEX);
	}

}
