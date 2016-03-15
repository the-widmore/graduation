package com.ccniit.graduation.validator;

public class StringVaildateFactory {

	public static enum StringVaildateType {
		TEL, EMAIL, URL
	}

	private static final StringVaildator TEL_VAILDATOT = new TELVaildator();

	// impl othor
	public boolean vaildate(StringVaildateType type, String source) {
		StringVaildator vaildator = null;
		switch (type) {
		case TEL:
			vaildator = TEL_VAILDATOT;
			break;

		default:
			break;
		}
		return vaildator.chech(source);
	}

}
