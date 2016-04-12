package com.ccniit.graduation.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ccniit.graduation.convertor.RequestParamsMapToArrayMap;
import com.ccniit.graduation.exception.CannotDoException;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.PermissionException;
import com.ccniit.graduation.pojo.db.VoteContent;
import com.ccniit.graduation.pojo.qo.VoteCreater;
import com.ccniit.graduation.pojo.qo.VotePublishVo;
import com.ccniit.graduation.pojo.vo.VoterGroupVo;
import com.ccniit.graduation.resource.VoteResource;
import com.ccniit.graduation.service.PermissionService;
import com.ccniit.graduation.service.PermissionService.ResourceType;
import com.ccniit.graduation.service.VoteContentService;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.service.VoterGroupService;
import com.ccniit.graduation.util.LoggerUtils;
import com.ccniit.graduation.util.ShiroUtils;
import com.ccniit.graduation.util.SpringMVCUtils;

@Controller
public class VoteController {

	private static final Logger DEV = LoggerUtils.getDev();

	@Resource
	private VoteService voteService;
	@Resource
	private PermissionService permissionService;
	@Resource
	private VoteContentService voteContentService;
	@Resource
	private VoterGroupService voterGroupService;

	public static final String VIEW_VOTE = "/vote/startVote.html";

	@RequestMapping(value = { VIEW_VOTE }, method = RequestMethod.GET)
	public String vote(ModelMap modelMap) {

		return VIEW_VOTE;
	}

	public static final String VIEW_CREATE_VOTE_FROM_FLIE = "/vote/createVoteFromFile.html";

	@RequestMapping(value = { VIEW_CREATE_VOTE_FROM_FLIE }, method = RequestMethod.GET)
	public String createVoteFromFile(ModelMap modelMap) {

		return VIEW_CREATE_VOTE_FROM_FLIE;
	}

	public static final String VIEW_CREATE_VOTE = "/vote/createVote.html";

	@RequestMapping(value = { VIEW_CREATE_VOTE }, method = RequestMethod.GET)
	public String createVote(ModelMap modelMap) {

		return VIEW_CREATE_VOTE;
	}

	private static final String CREATE_VOTE_DO = "/vote/createVote.do";

	@RequestMapping(value = CREATE_VOTE_DO, method = RequestMethod.POST)
	public String createVote(@ModelAttribute("creater") VoteCreater creater, ModelMap modelMap) throws IException {

		creater.setAuthor(ShiroUtils.getUserId());
		voteService.createVote(creater);

		// 编辑模式 选择

		return SpringMVCUtils.redirect(UserController.VIEW_USER_MY_VOTE);
	}

	public static final String VIEW_CREATE_ADVANCE_VOTE = "/vote/createAdvanceVote.html";

	@RequestMapping(value = { VIEW_CREATE_ADVANCE_VOTE }, method = RequestMethod.GET)
	public String createAdvanceVote(ModelMap modelMap) {
		return VIEW_CREATE_ADVANCE_VOTE;
	}

	// HTML编辑模式 TODO 添加 visible(可视化编辑模式)
	public static final String VIEW_EDIT_VOTE = "/vote/editVoteByHTML.html";
	public static final String EDIT_VOTE_BY_HTML_URL = "/vote/editVoteByHTML/{voteId}";

	@RequestMapping(value = { EDIT_VOTE_BY_HTML_URL }, method = { RequestMethod.GET, RequestMethod.POST })
	public String editVote(@PathVariable("voteId") Long voteId, ModelMap modelMap) throws IException {
		// TODO 权限检查、进度检查、账号检查
		boolean havePermission = permissionService.havePermission(ResourceType.vote, ShiroUtils.getUserId(), voteId);
		if (!havePermission) {
			throw new PermissionException("你没有访问该资源的权限");
		}

		int progress = voteService.selectVote(voteId).getProgress();
		if (VoteResource.EDITED == progress || VoteResource.CREATED == progress) {

		} else {
			throw new CannotDoException("你不能进行此操作");
		}

		modelMap.addAttribute("voteContent", voteContentService.loadVoteContent(voteId));
		modelMap.addAttribute("voteId", voteId);

		return VIEW_EDIT_VOTE;
	}

	public static final String FROM_VOTE_PREVIEW = "/vote/previewVote.do";
	public static final String VIEW_VOTE_PREVIEW = "/vote/previewVote.html";

	@RequestMapping(value = { FROM_VOTE_PREVIEW }, method = RequestMethod.POST)
	public String previewVoteAction(@RequestParam("voteText") String voteText, Model model) {

		model.addAttribute("voteText", voteText);

		return VIEW_VOTE_PREVIEW;
	}

	@Resource
	private MongoTemplate mongoTemplate;
	@Resource
	private RequestParamsMapToArrayMap requestParamsMapToArrayMap;

	public static final String FROM_VOTE_SUBMIT = "/vote/submitVote.do";
	public static final String FROM_VOTE_SUBMIT_SUCCESS = "/vote/voteSubmitSuccess.html";

	// 提交
	@RequestMapping(value = { FROM_VOTE_SUBMIT }, method = RequestMethod.POST)
	public String submitVoteAction(@ModelAttribute("content") VoteContent content, ModelMap modelMap) {

		voteContentService.updateVoteContent(content);
		modelMap.addAttribute("voteId", content.getId());

		return FROM_VOTE_SUBMIT_SUCCESS;
	}

	protected static final String VOTE_SUMMARY_URL = "/vote/summary/{voteId}";
	protected static final String VOTE_SUMMARY_VIEW = "/vote/voteSummary.html";

	@RequestMapping(value = VOTE_SUMMARY_URL, method = RequestMethod.GET)
	public String getVoteSummaty(ModelMap modelMap) {
		// TODO Auto generated method stub
		return VOTE_SUMMARY_VIEW;
	}

	protected static final String VOTE_ACTION_URL = "/vote/action/{voteId}";

	// 根据vote的进度，进行不同的操作
	@RequestMapping(value = VOTE_ACTION_URL, method = RequestMethod.GET)
	public String voteAction(@PathVariable("voteId") long voteId) throws IException {

		boolean havePermission = permissionService.havePermission(ResourceType.vote, ShiroUtils.getUserId(), voteId);
		if (!havePermission) {
			throw new PermissionException("你们有访问该资源的权限");
		}

		int progress = voteService.selectVote(voteId).getProgress();

		String targetUrl = null;
		switch (progress) {
		// 在创建后发布前都是编辑
		case VoteResource.CREATED:
		case VoteResource.EDITED:
			targetUrl = EDIT_VOTE_BY_HTML_URL.replace("\\{voteId\\}", String.valueOf(voteId));
			break;
		// 处于发布状态
		case VoteResource.PUBLISTED:
			targetUrl = VOTE_SUMMARY_URL.replace("\\{voteId\\}", String.valueOf(voteId));
			break;

		// 应经结束的
		case VoteResource.FINISHED:
			// TODO
			break;
		}

		DEV.debug(targetUrl);

		// TODO Auto generated method stub
		return SpringMVCUtils.redirect(targetUrl);
	}

	protected static final String PUBLISH_VOTE_URL = "/vote/publish/{voteId}";
	protected static final String PUBLISH_VOTE_CONFIG = "vote/publishVote.html";

	@RequestMapping(value = PUBLISH_VOTE_URL, method = RequestMethod.GET)
	public String publishVote(@PathVariable("voteId") long voteId, ModelMap modelMap) throws IException {

		boolean havePermission = permissionService.havePermission(ResourceType.vote, ShiroUtils.getUserId(), voteId);

		if (!havePermission) {
			throw new PermissionException("权限错误");
		}

		String title = voteService.selectVote(voteId).getTitle();
		modelMap.addAttribute("title", title);

		List<VoterGroupVo> voterGroupVos = voterGroupService.getVoterGroups(ShiroUtils.getUserId());
		modelMap.addAttribute("voterGroupVos", voterGroupVos);

		// 结束时间
		// TODO Auto generated method stub
		return PUBLISH_VOTE_CONFIG;
	}

	protected static final String PUBLISH_VOTE_DO = "/vote/publish.do";

	@RequestMapping(value = PUBLISH_VOTE_DO, method = RequestMethod.POST)
	public String doPublish(ModelMap modelMap, @ModelAttribute("publishVo") VotePublishVo publishVo) {

		voteService.updateVoteByPublish(publishVo);

		// TODO update vote
		return SpringMVCUtils.redirect(VOTE_SUMMARY_URL.replace("\\{voteId\\}", String.valueOf(publishVo.getVoteId())));
	}

}
