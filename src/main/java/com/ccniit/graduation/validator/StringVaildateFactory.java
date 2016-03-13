package com.ccniit.graduation.validator;

public class StringVaildateFactory {

	static enum StringVaildateType {
		TEL, EMAIL, URL
	}

	// impl othor
	public boolean vaildate(StringVaildateType type, String source) {
		StringVaildator vaildator = null;
		switch (type) {
		case TEL:
			vaildator = new TELVaildator();
			break;

		default:
			break;
		}
		return vaildator.chech(source);
	}

}
