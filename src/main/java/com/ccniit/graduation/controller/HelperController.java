package com.ccniit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccniit.graduation.util.StringUtils;

@Controller
public class HelperController {

	protected static final String GENERATE_PASSWORD_URL = "/helper/generatePassword";

	/**
	 * @param length
	 *            生成密码的长度
	 */
	@RequestMapping(value = GENERATE_PASSWORD_URL, method = RequestMethod.GET)
	public @ResponseBody String generatePassword(@RequestParam("length") int length) {
		if (length > 18) {
			length = 18;
		}

		if (length < 6) {
			length = 6;
		}

		return StringUtils.getRandomString(length);
	}

}
