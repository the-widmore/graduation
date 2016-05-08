package com.ccniit.graduation.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ccniit.graduation.builder.VoteSummaryVoBuilder;
import com.ccniit.graduation.dao.mongodb.VoteDataDao;
import com.ccniit.graduation.exception.CannotDoException;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.db.VoteContent;
import com.ccniit.graduation.pojo.doc.BaseVoteData;
import com.ccniit.graduation.pojo.qo.VoteCreater;
import com.ccniit.graduation.pojo.qo.VotePublishVo;
import com.ccniit.graduation.pojo.vo.VoteSummaryVo;
import com.ccniit.graduation.pojo.vo.VoteVo;
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
import com.ccniit.graduation.util.SystemUtils;

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
	@Resource
	private VoteSummaryVoBuilder voteSummaryVoBuilder;
	@Resource
	private VoteDataDao voteDataDao;

	// ### start Vote介绍
	protected static final String VOTE_URL = "/vote";
	protected static final String VOTE_START_URL_AND_VIEW = "/vote/startVote.html";

	@RequestMapping(value = { VOTE_URL, VOTE_START_URL_AND_VIEW }, method = RequestMethod.GET)
	public String vote(ModelMap modelMap) {
		return VOTE_START_URL_AND_VIEW;
	}
	// end Vote介绍 ###

	protected static final String VOTE_CREATE_VIEW = "/vote/createVote.html";

	// start Vote 创建
	@RequestMapping(value = { VOTE_CREATE_VIEW }, method = RequestMethod.GET)
	public String createVote(ModelMap modelMap) {
		return VIEW_CREATE_VOTE;
	}

	protected static final String VIEW_CREATE_VOTE = "/vote/createVote.html";

	protected static final String CREATE_VOTE_DO = "/vote/createVote.do";

	@RequestMapping(value = CREATE_VOTE_DO, method = RequestMethod.POST)
	public String createVote(@ModelAttribute("creater") VoteCreater creater, ModelMap modelMap) throws IException {

		creater.setAuthor(ShiroUtils.getUserId());
		voteService.createVote(creater);

		// 编辑模式 选择

		return SpringMVCUtils.redirect(UserController.VIEW_USER_MY_VOTE);
	}

	protected static final String VIEW_CREATE_ADVANCE_VOTE = "/vote/createAdvanceVote.html";

	@RequestMapping(value = { VIEW_CREATE_ADVANCE_VOTE }, method = RequestMethod.GET)
	public String createAdvanceVote(ModelMap modelMap) {
		return VIEW_CREATE_ADVANCE_VOTE;
	}
	// end Vote 创建 ###

	// HTML编辑模式 TODO 添加 visible(可视化编辑模式)
	protected static final String VIEW_EDIT_VOTE = "/vote/editVoteByHTML.html";
	protected static final String EDIT_VOTE_BY_HTML_URL = "/vote/editVoteByHTML/{voteId}";

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

	protected static final String FROM_VOTE_PREVIEW = "/vote/previewVote.do";
	protected static final String VIEW_VOTE_PREVIEW = "/vote/previewVote.html";

	@RequestMapping(value = { FROM_VOTE_PREVIEW }, method = RequestMethod.POST)
	public String previewVoteAction(@RequestParam("voteText") String voteText, Model model) {

		model.addAttribute("voteText", voteText);

		return VIEW_VOTE_PREVIEW;
	}

	protected static final String FROM_VOTE_SUBMIT = "/vote/submitVote.do";
	protected static final String VOTE_SUBMIT_SUCCESS = "/vote/voteSubmitSuccess.html";
	protected static final String VOTE_SUBMIT_FAILED = "/vote/voteSubmitFailed.html";

	// 提交
	@RequestMapping(value = { FROM_VOTE_SUBMIT }, method = RequestMethod.POST)
	public String submitVoteAction(@ModelAttribute() VoteContent content, ModelMap modelMap) throws IException {

		voteContentService.updateVoteContent(content);

		modelMap.addAttribute("voteId", content.getId());
		return SpringMVCUtils.redirect(VOTE_SUBMIT_SUCCESS);

	}

	@RequestMapping(value = VOTE_SUBMIT_SUCCESS, method = RequestMethod.GET)
	public String submitVoteSuccess(ModelMap modelMap, @RequestParam("voteId") Long voteId) {
		modelMap.addAttribute("voteId", voteId);
		return VOTE_SUBMIT_SUCCESS;
	}

	protected static final String VOTE_ACTION_URL = "/vote/action/{voteId}";

	// 根据vote的进度，进行不同的操作
	@RequestMapping(value = VOTE_ACTION_URL, method = RequestMethod.GET)
	public String voteAction(@PathVariable("voteId") Long voteId) throws IException {

		permissionService.havePermission(ResourceType.vote, ShiroUtils.getUserId(), voteId);

		int progress = voteService.selectVote(voteId).getProgress();

		String targetUrl = null;
		switch (progress) {
		// 在创建后发布前都是编辑
		case VoteResource.CREATED:
		case VoteResource.EDITED:
			targetUrl = SystemUtils.replaceVoteId(VoteEditController.EDIT_VOTE_BY_HTML_URL, voteId);
			break;
		// 处于发布状态 /应经结束的
		case VoteResource.PUBLISTED:
		case VoteResource.FINISHED:
			targetUrl = SystemUtils.replaceVoteId(VOTE_SUMMARY_URL, voteId);
			break;
		}

		// TODO Auto generated method stub
		return SpringMVCUtils.redirect(targetUrl);
	}

	// ### start Vote发布
	protected static final String PUBLISH_VOTE_URL = "/vote/publish/{voteId}";
	protected static final String PUBLISH_VOTE_CONFIG = "vote/publishVote.html";

	@RequestMapping(value = PUBLISH_VOTE_URL, method = RequestMethod.GET)
	public String publishVote(@PathVariable("voteId") long voteId, ModelMap modelMap) throws IException {
		Long userId = ShiroUtils.getUserId();
		permissionService.havePermission(ResourceType.vote, userId, voteId);

		String title = voteService.selectVote(voteId).getTitle();
		modelMap.addAttribute("title", title);

		List<VoterGroupVo> voterGroupVos = voterGroupService.getVoterGroups(userId);
		modelMap.addAttribute("voterGroupVos", voterGroupVos);

		// 结束时间
		// TODO Auto generated method stub
		return PUBLISH_VOTE_CONFIG;
	}

	protected static final String PUBLISH_VOTE_DO = "/vote/publish.do";

	@RequiresAuthentication()
	@RequestMapping(value = PUBLISH_VOTE_DO, method = RequestMethod.POST)
	public String doPublish(@ModelAttribute() VotePublishVo publishVo, ModelMap modelMap) throws IException {

		DEV.debug(publishVo.toString());

		voteService.updateVoteByPublish(publishVo, ShiroUtils.getUserId());

		// TODO update vote
		Long voteId = publishVo.getVoteId();
		modelMap.addAttribute("voteId", voteId);
		return SpringMVCUtils.redirect(SystemUtils.replaceVoteId(VOTE_SUMMARY_URL, voteId));
	}
	// end Vote发布 ###

	// ### 查看Vote
	protected static final String VOTE_SUMMARY_URL = "/vote/summary/{voteId}";
	protected static final String VOTE_SUMMARY_VIEW = "/vote/voteSummary.html";

	@RequestMapping(value = VOTE_SUMMARY_URL, method = RequestMethod.GET)
	public String getVoteSummaty(@PathVariable("voteId") Long voteId, ModelMap modelMap) throws IException {
		// TODO Auto generated method stub

		VoteSummaryVo voteSummaryVo = voteSummaryVoBuilder.build(voteId);
		VoteVo vote = voteService.selectVoteVo(voteId);

		modelMap.addAttribute("vote", vote);
		modelMap.addAttribute("voteSummary", voteSummaryVo);

		return VOTE_SUMMARY_VIEW;
	}
	// ###

	protected static final String WRITE_VOTE_ID = "/vote/write/{voteId}";
	protected static final String WRIET_VOTE_SORTED = "/s/{url}";

	@RequestMapping(value = WRITE_VOTE_ID, method = RequestMethod.GET)
	public ModelAndView writeById(@PathVariable("voteId") Long voteId) throws IException {
		return loadVote(voteId);
	}

	@RequestMapping(value = WRIET_VOTE_SORTED, method = RequestMethod.GET)
	public ModelAndView writeByUrl(@PathVariable("url") String url) throws IException {
		return loadVote(voteService.selectVoteIdByURL(url));
	}

	protected static final String VOTE_VIEW_URL = "/vote/vote.html";

	private ModelAndView loadVote(Long voteId) throws IException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(VOTE_VIEW_URL);

		VoteVo voteVo = voteService.selectVoteVo(voteId);

		DEV.debug(voteVo.toString());
		String voteContent = voteContentService.loadVoteContent(voteId);

		modelAndView.addObject("title", voteVo.getTitle());
		modelAndView.addObject("tags", voteVo.getTags());
		modelAndView.addObject("voteContent", voteContent);
		modelAndView.addObject("vid", voteVo.getId());

		return modelAndView;
	}

	private static final String WRITE_VOTE_DO = "/vote/write.do";
	protected static final String WRITE_SUCCESS = "/vote/vrite/success.html";
	protected static final String WRITE_SUCCESS_VIEW = "/vote/writeSuccess.html";

	@RequestMapping(value = WRITE_SUCCESS_VIEW, method = RequestMethod.GET)
	public String writeSuccess(Object model) {
		return WRITE_SUCCESS_VIEW;
	}

	@RequestMapping(value = WRITE_VOTE_DO, method = RequestMethod.POST)
	public String write(@RequestParam(value = "vid", required = true) final Long voteId, WebRequest request)
			throws IException {

		Vote vote = voteService.selectVote(voteId);
		String tableName = vote.getTableName();

		DEV.debug(tableName);
		Map<String, String[]> data = request.getParameterMap();
		voteDataDao.insertVoteData(tableName, new BaseVoteData(data));
		return SpringMVCUtils.redirect(WRITE_SUCCESS_VIEW);
	}

}
