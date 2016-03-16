package com.ccniit.graduation.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ccniit.graduation.service.VoterGroupService;

@Controller
public class EasyUIDataController {

	@Resource
	VoterGroupService voterGroupService;

	private static final String USER_VOTER_GROUP_DETAIL_URL = "/easyui/voterGroupDetail/{groupId}?";

	@RequestMapping(value = USER_VOTER_GROUP_DETAIL_URL, method = RequestMethod.GET)
	public String getVoterGroupDetail(@PathVariable("groupId") long groupId,
			@RequestParam(required = true, defaultValue = "0") int page) {

		return null;
	}

}
