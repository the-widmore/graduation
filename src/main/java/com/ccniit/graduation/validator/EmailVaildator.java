package com.ccniit.graduation.validator;

public class EmailVaildator implements StringVaildator {

	public static final String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

	@Override
	public boolean chech(String source) {
		return source.matches(EMAIL_REGEX);
	}

}
