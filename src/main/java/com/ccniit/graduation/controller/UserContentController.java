package com.ccniit.graduation.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.ParamsException;
import com.ccniit.graduation.exception.PermissionException;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.db.Vote.VoteCategory;
import com.ccniit.graduation.pojo.qo.VoteQueryByCategory;
import com.ccniit.graduation.pojo.qo.VoterQuery;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.Commons;
import com.ccniit.graduation.service.PermissionService;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.service.VoterGroupService;
import com.ccniit.graduation.service.VoterService;
import com.ccniit.graduation.util.ShiroUtils;

/**
 * 用户内容管理控制器
 */
@Controller
public class UserContentController {

	@Resource
	private VoteService voteService;
	@Resource
	private VoterGroupService voterGroupService;
	@Resource
	private PermissionService permissionService;
	@Resource
	private VoterService voterService;

	// linkman ##################

	protected static final String ACTION_CREATE_LINKMAN_BY_EXCEL = "/user/createLinkmanBuildByExcel.do";

	@RequestMapping(value = { ACTION_CREATE_LINKMAN_BY_EXCEL }, method = RequestMethod.POST)
	public String createLinkmanByExcelAction(@RequestParam(value = "file", required = true) MultipartFile file,
			HttpServletRequest request) throws IException {

		// TODO

		return VIEW_USER_MY_LINKMAN;
	}

	protected static final String ACTION_CREATE_LINKMAN_BY_TEXT = "/user/createLinkmanBuildByText.do";

	@RequestMapping(value = { ACTION_CREATE_LINKMAN_BY_TEXT }, method = RequestMethod.POST)
	public String createLinkmanByTextAction(BindingResult result, Model model) {

		return VIEW_USER_MY_LINKMAN;
	}

	protected static final String VIEW_USER_CREATE_LINKMAN_BUILD = "/user/createLinkmanBuild.html";

	@RequestMapping(value = { VIEW_USER_CREATE_LINKMAN_BUILD }, method = RequestMethod.GET)
	public String createLinkmanBuild(ModelMap modelMap) {
		// TODO
		return VIEW_USER_CREATE_LINKMAN_BUILD;
	}

	private static final String UPLOAD_LINKMEN_DO = "/user/uploadLinkman.do";

	@RequestMapping(value = UPLOAD_LINKMEN_DO, method = RequestMethod.PUT)
	public String post(File file, HttpServletRequest request) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(renameUploadFileName());
			FileInputStream fileInputStream = new FileInputStream(file);
			IOUtils.write(IOUtils.toByteArray(fileInputStream), fileOutputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String renameUploadFileName() {
		// TODO rename upload file name

		return null;
	}

	protected static final String VIEW_USER_LINKMAN_DETAIL = "/user/linkmanDetail.html";

	@RequestMapping(value = { VIEW_USER_LINKMAN_DETAIL }, method = RequestMethod.GET)
	public String linkmanDetail(ModelMap modelMap) {
		// TODO
		return VIEW_USER_LINKMAN_DETAIL;
	}

	protected static final String VIEW_USER_MY_LINKMAN = "/user/myLinkman.html";

	@RequestMapping(value = { VIEW_USER_MY_LINKMAN }, method = RequestMethod.GET)
	public String myLinkman(ModelMap modelMap) throws IException {
		modelMap.addAttribute("voterGroups", voterGroupService.getVoterGroups(ShiroUtils.getUserId()));
		return VIEW_USER_MY_LINKMAN;
	}

	protected static final String VIEW_LINKMAN_DETAIL_URL = "/user/linkmanDetail/{voterGroup}";

	@RequestMapping(value = { VIEW_LINKMAN_DETAIL_URL }, method = RequestMethod.GET)
	public String linkmanDetail(@PathVariable("voterGroup") Long voterGroup,
			@RequestParam(required = true, value = "page", defaultValue = "1") int page, Model model)
			throws IException {
		// 权限验证
		Long author = ShiroUtils.getUserId();
		boolean havePermisssion = permissionService.voterGroupHavePermission(author, voterGroup);

		if (!havePermisssion) {
			throw new PermissionException("你没有访问该资源的权限");
		}

		VoterQuery voterQuery = new VoterQuery(author, voterGroup);
		voterQuery.setPageSize(Commons.LINKMAN_PAGE_SIZE);
		voterQuery.setOffset(Commons.LINKMAN_PAGE_SIZE * (page - 1));

		List<Voter> voters = voterService.selectVoterFromVoterGroup(voterQuery);
		model.addAttribute("voters", voters);

		// TODO
		return VIEW_USER_LINKMAN_DETAIL;
	}

	// ################## linkman

	protected static final String VIEW_USER_MY_VOTE = "/user/myVote.html";

	@RequestMapping(value = { VIEW_USER_MY_VOTE }, method = RequestMethod.GET)
	public ModelAndView myVote(@RequestParam(value = "page", defaultValue = "1", required = true) int page,
			ModelMap modelMap) throws IException {
		return getVoteVos(VoteCategory.vote, page);
	}

	protected static final String VIEW_USER_MY_POLL = "/user/myPoll.html";

	@RequestMapping(value = { VIEW_USER_MY_POLL }, method = RequestMethod.GET)
	public ModelAndView myPoll(@RequestParam(value = "page", defaultValue = "1", required = true) int page,
			ModelMap modelMap) throws IException {
		return getVoteVos(VoteCategory.poll, page);
	}

	protected static final String VIEW_USER_MY_INFO_GATHER = "/user/myInfoGather.html";

	@RequestMapping(value = { VIEW_USER_MY_INFO_GATHER }, method = RequestMethod.GET)
	public ModelAndView myInfoGather(@RequestParam(value = "page", defaultValue = "1", required = true) int page,
			ModelMap modelMap) throws IException {
		return getVoteVos(VoteCategory.info, page);
	}

	private ModelAndView getVoteVos(VoteCategory category, int page) throws IException {
		if (page < 0) {
			throw new ParamsException("参数page不能小于0");
		}

		String resultPage = null;

		switch (category) {
		case poll:
			resultPage = VIEW_USER_MY_POLL;
			break;
		case vote:
			resultPage = VIEW_USER_MY_VOTE;
			break;
		case info:
			resultPage = VIEW_USER_MY_INFO_GATHER;
			break;
		default:
			break;
		}

		VoteQueryByCategory qurey = new VoteQueryByCategory(ShiroUtils.getUserId(), category.toString());
		qurey.setPageSize(Commons.VOTE_PAGE_SIZE);
		qurey.setOffset(Commons.VOTE_PAGE_SIZE * (page - 1));

		List<VoteVo> voteVos = voteService.selectVoteVos(qurey);

		ModelAndView modelAndView = new ModelAndView(resultPage);
		modelAndView.addObject("voteVos", voteVos);
		modelAndView.addObject("currentPage", page);

		return modelAndView;
	}

}
