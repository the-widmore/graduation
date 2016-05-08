package com.ccniit.graduation.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccniit.graduation.exception.CannotDoException;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.resource.VoteResource;
import com.ccniit.graduation.service.PermissionService;
import com.ccniit.graduation.service.PermissionService.ResourceType;
import com.ccniit.graduation.service.VoteContentService;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.ShiroUtils;

@Controller
public class VoteEditController {

	@Resource
	private PermissionService permissionService;
	@Resource
	private VoteService voteService;
	@Resource
	private VoteContentService voteContentService;

	protected static final String VOTE_EDIT_PREFIX = "/vote/edit";
	protected static final String VOTE_EDIT_URL_AND_VIEW = "";

	@RequestMapping(value = { VOTE_EDIT_PREFIX, VOTE_EDIT_URL_AND_VIEW }, method = RequestMethod.GET)
	public String voteEdit(Object model) {
		// TODO Auto generated method stub
		return null;
	}

	// HTML编辑模式 TODO 添加 visible(可视化编辑模式)
	protected static final String VIEW_EDIT_VOTE = "/vote/edit/byHTML.html";
	protected static final String EDIT_VOTE_BY_HTML_URL = "/vote/edit/byHTML/{voteId}";

	@RequestMapping(value = { EDIT_VOTE_BY_HTML_URL }, method = { RequestMethod.GET, RequestMethod.POST })
	public String editVote(@PathVariable("voteId") Long voteId, ModelMap modelMap) throws IException {
		// TODO 权限检查、进度检查、账号检查
		permissionService.havePermission(ResourceType.vote, ShiroUtils.getUserId(), voteId);

		int progress = voteService.selectVote(voteId).getProgress();
		if (VoteResource.EDITED == progress || VoteResource.CREATED == progress) {

		} else {
			throw new CannotDoException("该资源应经发布了，无法再进行编辑了。");
		}

		modelMap.addAttribute("voteContent", voteContentService.loadVoteContent(voteId));
		modelMap.addAttribute("voteId", voteId);

		return VIEW_EDIT_VOTE;
	}

}
