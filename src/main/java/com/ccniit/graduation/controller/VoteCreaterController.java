package com.ccniit.graduation.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.qo.VoteCreater;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.ShiroUtils;
import com.ccniit.graduation.util.SpringMVCUtils;

@Controller
public class VoteCreaterController {

	protected static final String VOTE_CREATE_BY_FILE_URL = "/vote/creater/file.html";
	protected static final String VOTE_CREATE_BY_FILE_VIEW = "/vote/createVoteFromFile.html";

	@Resource
	private VoteService voteService;

	@RequestMapping(value = { VOTE_CREATE_BY_FILE_URL }, method = RequestMethod.GET)
	public String createVoteFromFile(ModelMap modelMap) {

		return VOTE_CREATE_BY_FILE_VIEW;
	}

	protected static final String VOTE_CREATE_BY_FILE_DO = "";

	protected static final String VIEW_CREATE_ADVANCE_VOTE = "/vote/createAdvanceVote.html";

	@RequestMapping(value = { VIEW_CREATE_ADVANCE_VOTE }, method = RequestMethod.GET)
	public String createAdvanceVote(ModelMap modelMap) {
		return VIEW_CREATE_ADVANCE_VOTE;
	}
	// end Vote 创建 ###

	protected static final String CREATE_VOTE_DO = "/vote/createVote.do";

	@RequestMapping(value = CREATE_VOTE_DO, method = RequestMethod.POST)
	public String createVote(@ModelAttribute("creater") VoteCreater creater, ModelMap modelMap) throws IException {

		creater.setAuthor(ShiroUtils.getUserId());
		voteService.createVote(creater);

		// 编辑模式 选择

		return SpringMVCUtils.redirect(UserController.VIEW_USER_MY_VOTE);
	}

}
