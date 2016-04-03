package com.ccniit.graduation.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.doc.PrivateVoteData;
import com.ccniit.graduation.pojo.qo.VoteCreater;
import com.ccniit.graduation.service.PermissionService;
import com.ccniit.graduation.service.PermissionService.ResourceType;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.LoggerUtils;
import com.ccniit.graduation.util.ShiroUtils;

@Controller
public class VoteController {

	private static final Logger DEV = LoggerUtils.getDev();

	@Resource
	VoteService voteService;
	@Resource
	PermissionService permissionService;

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

		// 编辑模式 选择

		return UserController.VIEW_USER_MY_VOTE;
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
	public String editVote(@PathVariable("voteId") Long voteId) throws IException {
		// TODO 权限检查、进度检查、账号检查
		permissionService.havePermission(ResourceType.vote, ShiroUtils.getUserId(), voteId);

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
	MongoTemplate mongoTemplate;
	@Resource
	RequestParamsMapToArrayMap requestParamsMapToArrayMap;

	public static final String FROM_VOTE_SUBMIT = "/vote/submitVote.html";
	public static final String FROM_VOTE_SUBMIT_SUCCESS = "/vote/voteSubmitSuccess.html";

	@RequestMapping(value = { FROM_VOTE_SUBMIT }, method = RequestMethod.POST)
	public String submitVoteAction(HttpServletRequest request) {
		// TODO
		Map<String, String[]> paramaterMap = request.getParameterMap();

		PrivateVoteData voteData = new PrivateVoteData();
		Map<String, List<String>> arrayMap = requestParamsMapToArrayMap.convert(paramaterMap);

		voteData.setData(arrayMap);

		mongoTemplate.insert(voteData);

		int questionCounter = paramaterMap.size();

		DEV.info("questionCounter:{}", questionCounter);

		for (Map.Entry<String, String[]> entry : paramaterMap.entrySet()) {
			System.out.println(entry.getKey());
			String[] values = entry.getValue();
			for (int i = 0; i < values.length; i++) {
				DEV.info(values[i]);
			}
		}

		return FROM_VOTE_SUBMIT_SUCCESS;
	}

	protected static final String VOTE_SUMMARY_URL = "/vote/summary/{voteId}";

	@RequestMapping(value = VOTE_SUMMARY_URL, method = RequestMethod.GET)
	public String getVoteSummaty(ModelMap modelMap) {
		// TODO Auto generated method stub
		return null;
	}

}
