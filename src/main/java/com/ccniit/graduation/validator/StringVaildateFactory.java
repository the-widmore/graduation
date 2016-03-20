package com.ccniit.graduation.validator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.resource.SpringScope;

@Component("stringVaildateFactory")
@Scope(SpringScope.SINGLETON)
public class StringVaildateFactory {

	public static enum StringVaildateType {
		TEL, EMAIL, URL
	}

	private static final StringVaildator TEL_VAILDATOT = new TELVaildator();
	private static final StringVaildator EMAIL_VAILDATOT = new EmailVaildator();

	// impl othor
	public boolean vaildate(StringVaildateType type, String source) {
		StringVaildator vaildator = null;
		switch (type) {
		case TEL:
			vaildator = TEL_VAILDATOT;
			break;
		case EMAIL:
			vaildator = EMAIL_VAILDATOT;
			break;
		default:
			break;
		}
		return vaildator.chech(source);
	}

}
