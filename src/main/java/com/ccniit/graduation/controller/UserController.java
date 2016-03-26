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
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ccniit.graduation.convertor.AuthorToAuthorBaseUpdater;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.NotLoginException;
import com.ccniit.graduation.exception.PermissionException;
import com.ccniit.graduation.exception.ServerException;
import com.ccniit.graduation.pojo.common.UserToken;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.qo.AuthorBaseUpdater;
import com.ccniit.graduation.pojo.qo.AuthorInfoUpdater;
import com.ccniit.graduation.pojo.qo.VoteQueryByCategory;
import com.ccniit.graduation.pojo.qo.VoterQuery;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;
import com.ccniit.graduation.pojo.vo.UserRegister;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.Constants;
import com.ccniit.graduation.resource.VoteResource;
import com.ccniit.graduation.service.AuthorService;
import com.ccniit.graduation.service.ResourcePermissionService;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.service.VoterGroupService;
import com.ccniit.graduation.service.VoterService;
import com.ccniit.graduation.util.LoggerUtils;
import com.ccniit.graduation.util.ShiroUtils;
import com.ccniit.graduation.util.SpringMVCUtils;

@Controller
@SessionAttributes(names = { "authorContentCounter" })
public class UserController {

	private static final Logger LOG_DEV = LoggerUtils.getDev();

	@Resource
	private AuthorService authorService;
	@Resource
	private VoterService voterService;
	@Resource
	private VoteService voteService;
	@Resource
	private VoterGroupService voterGroupService;
	@Resource
	private ResourcePermissionService resourcePermissionService;
	@Resource
	AuthorToAuthorBaseUpdater authorToAuthorBaseUpdater;

	public static final String VIEW_USER = "/user";
	public static final String VIEW_USER_SELF_CENTER = "/user/selfCenter.html";

	@RequestMapping(value = { VIEW_USER_SELF_CENTER, VIEW_USER })
	public String selfCenter(ModelMap modelMap) throws IException {
		long id = getAuthorId();

		if (0 == id) {
			throw new NotLoginException("必须登录");
		}

		modelMap.addAttribute("authorContentCounter", getAuthorContentCounter(id));

		return VIEW_USER_SELF_CENTER;
	}

	private AuthorContentCounter getAuthorContentCounter(long id) {
		return authorService.getAuthorContentCounter(id);
	}

	public static final String VIEW_USER_CREATE_LINKMAN_BUILD = "/user/createLinkmanBuild.html";

	@RequestMapping(value = { VIEW_USER_CREATE_LINKMAN_BUILD }, method = RequestMethod.GET)
	public String createLinkmanBuild(Model model) {
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

	public static final String VIEW_USER_LINKMAN_DETAIL = "/user/linkmanDetail.html";

	@RequiresAuthentication
	@RequestMapping(value = { VIEW_USER_LINKMAN_DETAIL }, method = RequestMethod.GET)
	public String linkmanDetail(ModelMap modelMap) {

		return VIEW_USER_LINKMAN_DETAIL;
	}

	public static final String VIEW_USER_MY_LINKMAN = "/user/myLinkman.html";

	@RequestMapping(value = { VIEW_USER_MY_LINKMAN }, method = RequestMethod.GET)
	public String myLinkman(ModelMap modelMap) {
		modelMap.addAttribute("voterGroups", voterGroupService.getVoterGroups(getAuthorId()));
		return VIEW_USER_MY_LINKMAN;
	}

	public static final String VIEW_USER_MY_POLL = "/user/myPoll.html";

	@RequestMapping(value = { VIEW_USER_MY_POLL }, method = RequestMethod.GET)
	public String myPoll(@RequestParam(value = "page", defaultValue = "1", required = true) int page,
			ModelMap modelMap) {
		VoteQueryByCategory query = new VoteQueryByCategory(getAuthorId(), VoteResource.Category.poll.toString());

		query.setPageSize(VoteResource.VOTE_PAGE_SIZE);
		query.setOffset(VoteResource.VOTE_PAGE_SIZE * page);

		List<VoteVo> voteVos = voteService.selectVoteVos(query);
		modelMap.addAttribute("voteVos", voteVos);
		return VIEW_USER_MY_POLL;
	}

	public static final String VIEW_USER_MY_INFO_GATHER = "/user/myInfoGather.html";

	@RequestMapping(value = { VIEW_USER_MY_INFO_GATHER }, method = RequestMethod.GET)
	public String myInfoGather(ModelMap modelMap) {

		return VIEW_USER_MY_INFO_GATHER;
	}

	public static final String VIEW_USER_MY_VOTE = "/user/myVote.html";

	@RequestMapping(value = { VIEW_USER_MY_VOTE }, method = RequestMethod.GET)
	public String myVote(ModelMap modelMap) {

		return VIEW_USER_MY_VOTE;
	}

	public static final String VIEW_USER_USER_ACCOUNT = "/user/userAccount.html";

	@RequestMapping(value = { VIEW_USER_USER_ACCOUNT }, method = RequestMethod.GET)
	public String userAccount(ModelMap modelMap) {

		return VIEW_USER_USER_ACCOUNT;
	}

	public static final String VIEW_USER_CONSLOE = "/user/userConsole.html";

	@RequestMapping(value = { VIEW_USER_CONSLOE }, method = RequestMethod.GET)
	public String userConsole(ModelMap modelMap) {

		return VIEW_USER_CONSLOE;
	}

	public static final String VIEW_USER_LOG_DEVIN = "/user/userLogin.html";

	@RequestMapping(value = { VIEW_USER_LOG_DEVIN }, method = RequestMethod.GET)
	public String userLogin(Model model) {
		model.addAttribute("userToken", new UserToken());
		return VIEW_USER_LOG_DEVIN;
	}

	public static final String VIEW_USER_ORDER = "/user/userOrder.html";

	@RequestMapping(value = { VIEW_USER_ORDER }, method = RequestMethod.GET)
	public String userOrder(ModelMap model) {

		return VIEW_USER_ORDER;
	}

	public static final String VIEW_USER_PROFILE = "/user/userProfile.html";

	@RequestMapping(value = { VIEW_USER_PROFILE }, method = RequestMethod.GET)
	public String userProfile(@ModelAttribute("baseUpdater") AuthorBaseUpdater baseUpdater,
			@ModelAttribute("infoUpdater") AuthorInfoUpdater infoUpdater, Model model, BindingResult result)
					throws IException {

		if (result.hasErrors()) {
			throw new ServerException("");
		}

		long id = getAuthorId();

		Author author = authorService.findAuthorById(id);
		baseUpdater = authorToAuthorBaseUpdater.convert(author);

		// TODO set userDetailInfo value

		model.addAttribute("baseUpdater", baseUpdater);
		model.addAttribute("infoUpdater", infoUpdater);

		return VIEW_USER_PROFILE;
	}

	public static final String VIEW_USER_SIGN_IN = "/user/userSignIn.html";

	@RequestMapping(value = { VIEW_USER_SIGN_IN }, method = RequestMethod.GET)
	public String userSignIn(ModelMap modelMap) {

		return VIEW_USER_SIGN_IN;
	}

	public static final String VIEW_USER_UNAUTHORIZED = "/user/userUnauthorized.html";

	@RequestMapping(value = { VIEW_USER_UNAUTHORIZED }, method = RequestMethod.GET)
	public String userUnauthorized(ModelMap modelMap) {

		return VIEW_USER_UNAUTHORIZED;
	}

	public static final String VIEW_LINKMAN_DETAIL_URL = "/user/linkmanDetail/{voterGroup}";

	@RequestMapping(value = { VIEW_LINKMAN_DETAIL_URL }, method = RequestMethod.GET)
	public String linkmanDetail(@PathVariable int voterGroup,
			@RequestParam(required = true, value = "page", defaultValue = "0") int page, Model model)
					throws IException {
		// 权限验证
		long author = getAuthorId();
		boolean havePermisssion = resourcePermissionService.voterGroupHavePermission(author, voterGroup);

		if (!havePermisssion) {
			throw new PermissionException("你没有访问该资源的权限");
		}

		VoterQuery voterQuery = new VoterQuery(voterGroup, (page * 20));

		List<Voter> voters = voterService.selectVoterFromVoterGroup(voterQuery);
		model.addAttribute("voters", voters);

		// TODO
		return VIEW_USER_LINKMAN_DETAIL;
	}

	//////////////////////////////////////////////////////////////////////////////////

	public static final String FORM_USER_SIGN_IN = "/user/userSignIn.do";
	public static final String USER_SIGN_IN_RESULT = "/user/signInSuccess.html";

	@RequestMapping(value = { FORM_USER_SIGN_IN }, method = RequestMethod.POST)
	public String signInAction(@ModelAttribute("userRegister") UserRegister userRegister, BindingResult result,
			Model model) throws Exception {

		String verifyCode = (String) ShiroUtils.getSessionValue(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

		LOG_DEV.info("verifyCode : " + verifyCode);

		if (!verifyCode.equalsIgnoreCase(userRegister.getVerifyCode().trim())) {
			model.addAttribute("errorMessageVerifyCode", "验证码错误");
			return FORM_USER_SIGN_IN;
		}

		if (authorService.authorIsExist(userRegister.getEmail())) {
			model.addAttribute("errorMessageEmail", "该邮箱已经注册");
			return FORM_USER_SIGN_IN;
		}

		if (!userRegister.getPassword().equals(userRegister.getRePassword())) {
			model.addAttribute("errorMessageRePassword", "两次密码不一致");
			return FORM_USER_SIGN_IN;
		}

		Author author = new Author();
		author.setEmail(userRegister.getEmail());
		author.setPassword(userRegister.getPassword());

		authorService.register(author);

		return USER_SIGN_IN_RESULT;
	}

	public static final String VIEW_USER_LOGIN = "/user/userLogin.do";
	public static final String AUTHOR_LOGIN_RESULT = "/user/selfCenter.html";

	@RequestMapping(value = { VIEW_USER_LOGIN }, method = RequestMethod.POST)
	public String loginAction(@ModelAttribute("userToken") UserToken userToken, BindingResult result, Model model) {

		UsernamePasswordToken token = new UsernamePasswordToken(userToken.getEmail(), userToken.getPassword());
		Subject currentUser = ShiroUtils.getSubject();
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			model.addAttribute("message", "account or password error!");
			e.printStackTrace(System.out);
			return VIEW_USER_LOGIN;
		}

		if (currentUser.isAuthenticated()) {
			Session session = currentUser.getSession(true);
			long id = authorService.getAuthorIdByEmail(userToken.getEmail());

			LOG_DEV.debug("Email:{} ID:{}", currentUser.getPrincipal(), id);

			session.setAttribute(Constants.SESSION_KEY_AUTHOR_ID, id);
			return SpringMVCUtils.redirect(AUTHOR_LOGIN_RESULT);
		} else {
			model.addAttribute("message", "account or password error!");
			return VIEW_USER_LOG_DEVIN;
		}
	}

	public static final String ACTION_LOG_DEVOUT_URL = "/user/logout.do";
	public static final String ACTION_LOG_DEVOUT_RESULT = "../index";

	@RequestMapping(value = { ACTION_LOG_DEVOUT_URL }, method = RequestMethod.GET)
	public String logoutAction(ModelMap modelMap) {
		modelMap.addAttribute("message", "Logout success!");

		try {
			Subject subject = ShiroUtils.getSubject();
			subject.getSession().stop();
			subject.logout();
		} catch (Exception e) {
			LOG_DEV.error("注销错误", e);
		}

		return SpringMVCUtils.redirect(ACTION_LOG_DEVOUT_RESULT);
	}

	public static final String ACTION_CREATE_LINKMAN_BY_EXCEL = "/user/createLinkmanBuildByExcel.do";

	@RequestMapping(value = { ACTION_CREATE_LINKMAN_BY_EXCEL }, method = RequestMethod.POST)
	public String createLinkmanByExcelAction(@RequestParam(value = "file", required = true) MultipartFile file,
			HttpServletRequest request) throws IException {

		// TODO

		return VIEW_USER_MY_LINKMAN;
	}

	public static final String ACTION_CREATE_LINKMAN_BY_TEXT = "/user/createLinkmanBuildByText.do";
	public static final String VIEW_LINKMAN_FORMAT_ERROR = "/help/linkmanCreateFormate.html";

	@RequestMapping(value = { ACTION_CREATE_LINKMAN_BY_TEXT }, method = RequestMethod.POST)
	public String createLinkmanByTextAction(BindingResult result, Model model) {

		return VIEW_USER_MY_LINKMAN;
	}

	public static final String FORM_UPDATE_USER_BASE_INFO = "/user/updateUserBaseInfo.do";

	@RequestMapping(value = { FORM_UPDATE_USER_BASE_INFO }, method = RequestMethod.POST)
	public String updateUserBaseInfoAction(@ModelAttribute("baseUpdater") AuthorBaseUpdater baseUpdater, Model model) {

		UserToken userToken = new UserToken(baseUpdater.getEmail(), baseUpdater.getOldPassword());
		boolean isMatched = authorService.authentication(userToken);
		if (!isMatched) {
			model.addAttribute("errorMessagePassword", "password error");
		}

		if (!baseUpdater.getNewPassword().equals(baseUpdater.getConfirmPassword())) {
			model.addAttribute("errorMessageNewPassword", "new password not same");
		}

		baseUpdater.setId(getAuthorId());
		authorService.updateAuthorBase(baseUpdater);
		return VIEW_USER_PROFILE;
	}

	public static final String FORM_UPDATE_USER_DETAIL_INFO = "/user/updateUserDetailInfo.do";

	@RequestMapping(value = FORM_UPDATE_USER_DETAIL_INFO, method = RequestMethod.POST)
	public String updateDetailProfile(Model model) {

		// TODO

		return VIEW_USER_PROFILE;
	}

	private long getAuthorId() {
		long authorId = -1L;
		try {
			authorId = ShiroUtils.getUserId();
		} catch (IException e) {
			LOG_DEV.error("获取Author.id错误", e);
		}
		return authorId;
	}

}
