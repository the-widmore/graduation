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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.NotLoginException;
import com.ccniit.graduation.pojo.common.UserBaseInfo;
import com.ccniit.graduation.pojo.common.UserToken;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.db.VoterGroup;
import com.ccniit.graduation.pojo.vo.UserDetailInfo;
import com.ccniit.graduation.pojo.vo.UserRegister;
import com.ccniit.graduation.pojo.vo.VoterGroupAndVoters;
import com.ccniit.graduation.pojo.vo.VoterQuery;
import com.ccniit.graduation.resource.Constants;
import com.ccniit.graduation.service.AuthorService;
import com.ccniit.graduation.service.VoterGruopService;
import com.ccniit.graduation.service.VoterService;
import com.ccniit.graduation.util.ShiroUtils;
import com.ccniit.graduation.util.StringUtils;

@Controller
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Resource
	private AuthorService authorService;
	@Resource
	private VoterService voterService;
	@Resource
	private VoterGruopService voterGroupService;

	public static final String VIEW_USER_SELF_CENTER = "/user/selfCenter.html";

	@RequestMapping(value = { VIEW_USER_SELF_CENTER })
	public String selfCenter(ModelMap modelMap) throws IException {
		long id = ShiroUtils.getUserId();

		if (0 == id) {
			throw new NotLoginException("必须登录");
		}

		modelMap.addAttribute("userShow", authorService.getShowName(id));
		return VIEW_USER_SELF_CENTER;
	}

	public static final String VIEW_USER_CREATE_LINKMAN_BUILD = "/user/createLinkmanBuild.html";

	@RequestMapping(value = { VIEW_USER_CREATE_LINKMAN_BUILD }, method = RequestMethod.GET)
	public String createLinkmanBuild(Model model) {
		VoterGroupAndVoters voterGroupAndVoters = new VoterGroupAndVoters();
		voterGroupAndVoters.setGroupDescription("描述你的该联系人库...");
		model.addAttribute("voterGroupAndVoters", voterGroupAndVoters);
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

	@RequestMapping(value = { VIEW_USER_LINKMAN_DETAIL }, method = RequestMethod.GET)
	public String linkmanDetail(ModelMap modelMap) {

		return VIEW_USER_LINKMAN_DETAIL;
	}

	public static final String VIEW_USER_MY_INFO_GATHER = "/user/myInfoGather.html";

	@RequestMapping(value = { VIEW_USER_MY_INFO_GATHER }, method = RequestMethod.GET)
	public String myInfoGather(ModelMap modelMap) {

		return VIEW_USER_MY_INFO_GATHER;
	}

	public static final String VIEW_USER_MY_LINKMAN = "/user/myLinkman.html";

	@RequestMapping(value = { VIEW_USER_MY_LINKMAN }, method = RequestMethod.GET)
	public String myLinkman(ModelMap modelMap) {
		modelMap.addAttribute("linkmans", voterGroupService.getVoterGroups(ShiroUtils.getUserId()));
		return VIEW_USER_MY_LINKMAN;
	}

	public static final String VIEW_USER_MY_POLL = "/user/myPoll.html";

	@RequestMapping(value = { VIEW_USER_MY_POLL }, method = RequestMethod.GET)
	public String myPoll(ModelMap modelMap) {

		return VIEW_USER_MY_POLL;
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

	public static final String VIEW_USER_LOGIN = "/user/userLogin.html";

	@RequestMapping(value = { VIEW_USER_LOGIN }, method = RequestMethod.GET)
	public String userLogin(Model model) {
		model.addAttribute("userToken", new UserToken());
		return VIEW_USER_LOGIN;
	}

	public static final String VIEW_USER_ORDER = "/user/userOrder.html";

	@RequestMapping(value = { VIEW_USER_ORDER }, method = RequestMethod.GET)
	public String userOrder(ModelMap model) {

		return VIEW_USER_ORDER;
	}

	public static final String VIEW_USER_PROFILE = "/user/userProfile.html";

	@RequestMapping(value = { VIEW_USER_PROFILE }, method = RequestMethod.GET)
	public String userProfile(Model model) {

		long id = ShiroUtils.getUserId();

		Author author = authorService.findAuthorById(id);

		UserBaseInfo userBaseInfo = new UserBaseInfo();
		userBaseInfo.setEmail(author.getEmail());
		userBaseInfo.setNickname(author.getNickname());

		UserDetailInfo userDetailInfo = new UserDetailInfo();
		// TODO set userDetailInfo value

		model.addAttribute("userBaseInfo", userBaseInfo);
		model.addAttribute("userDetailInfo", userDetailInfo);

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

	// linkman group detail

	public static final String VIEW_LINKMAN_DETAIL_PAGE = "/user/linkmanDetail/{voterGroupId}/{page}";

	@RequestMapping(value = { VIEW_LINKMAN_DETAIL_PAGE }, method = RequestMethod.GET)
	public String linkmanDetailByIdAndPage(@PathVariable int voterGroupId, @PathVariable int page, ModelMap model) {

		VoterQuery voterQuery = new VoterQuery(voterGroupId, (page - 1) * 20);

		String description = voterGroupService.getVoterGroupDescription(voterGroupId);
		model.addAttribute("description", description);

		List<Voter> voters = voterGroupService.getVotersByVoterGroupIdAndPage(voterQuery);
		model.addAttribute("voters", voters);
		return VIEW_USER_LINKMAN_DETAIL;
	}

	//////////////////////////////////////////////////////////////////////////////////

	public static final String FORM_USER_SIGN_IN = "/user/userSignIn.do";
	public static final String USER_SIGN_IN_RESULT = "/user/signInSuccess.html";

	@RequestMapping(value = { FORM_USER_SIGN_IN }, method = RequestMethod.POST)
	public String signInAction(@ModelAttribute("userRegister") UserRegister userRegister, BindingResult result,
			Model model) throws Exception {

		String verifyCode = (String) ShiroUtils.getSessionValue(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

		LOG.info("verifyCode : " + verifyCode);

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
		author.setNickname(userRegister.getNickname());

		authorService.register(author);

		return USER_SIGN_IN_RESULT;
	}

	public static final String FORM_USER_LOGIN = "/user/userLogin.do";
	public static final String USER_LOGIN_RESULT = "/user/selfCenter.html";

	@RequestMapping(value = { FORM_USER_LOGIN }, method = RequestMethod.POST)
	public String loginAction(@ModelAttribute("userToken") UserToken userToken, BindingResult result, Model model) {

		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userToken.getEmail(), userToken.getPassword());

		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			model.addAttribute("message", "account or password error!");
			e.printStackTrace(System.out);
			return VIEW_USER_LOGIN;
		}

		if (currentUser.isAuthenticated()) {
			LOG.info(currentUser.getPrincipal().toString() + ": logined!");
			Session session = currentUser.getSession(true);
			long id = authorService.getAuthorIdByEmail(userToken.getEmail());
			session.setAttribute(Constants.SESSION_KEY_USER_ID, id);
			session.setAttribute(Constants.SESSION_KEY_SHOW_NAME, authorService.getShowName(id));
			return VIEW_USER_SELF_CENTER;
		} else {
			model.addAttribute("message", "account or password error!");
			return VIEW_USER_LOGIN;
		}
	}

	public static final String ACTION_LOGOUT_URL = "/user/logout.do";
	public static final String ACTION_LOGOUT_RESULT = "../index";

	@RequestMapping(value = { ACTION_LOGOUT_URL }, method = RequestMethod.GET)
	public String logoutAction(ModelMap modelMap) {
		modelMap.addAttribute("message", "Logout success!");
		Subject subject = ShiroUtils.getSubject();
		subject.getSession().removeAttribute(Constants.SESSION_KEY_USER_ID);
		subject.getSession().removeAttribute(Constants.SESSION_KEY_SHOW_NAME);
		subject.logout();

		return ACTION_LOGOUT_RESULT;
	}

	public static final String ACTION_CREATE_LINKMAN_BY_EXCEL = "/user/createLinkmanBuildByExcel.do";

	@RequestMapping(value = { ACTION_CREATE_LINKMAN_BY_EXCEL }, method = RequestMethod.POST)
	public String createLinkmanByExcelAction(@RequestParam(value = "file", required = true) MultipartFile file,
			HttpServletRequest request) throws IException {

		String tempDir = null;
		try {
			tempDir = WebUtils.getRealPath(request.getServletContext(), "/WEB-INF/fileUpload/temp");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String originalName = file.getOriginalFilename();
		String filePath = tempDir + StringUtils.getUUID() + ".xls";

		// TODO

		return VIEW_USER_MY_LINKMAN;
	}

	public static final String ACTION_CREATE_LINKMAN_BY_TEXT = "/user/createLinkmanBuildByText.do";
	public static final String VIEW_LINKMAN_FORMAT_ERROR = "/help/linkmanCreateFormate.html";

	private static final String SEPARATOR_LINKMAN = ";";
	private static final String SEPARATOR_USERNAME_ALIAS = ":";
	private static final String EMAIL_USERNAME_REGULAR = "[\\w[.-]]+";
	private static final String EMAIL_SERVICE_REGULAR = "@[\\w[.-]]+\\.[\\w]+";

	@RequestMapping(value = { ACTION_CREATE_LINKMAN_BY_TEXT }, method = RequestMethod.POST)
	public String createLinkmanByTextAction(
			@ModelAttribute("voterGroupAndVoters") VoterGroupAndVoters voterGroupAndVoters, BindingResult result,
			Model model) {

		// check defaultEmailService
		String defaultEmailService = voterGroupAndVoters.getDefaultEmailService();
		if ((null != defaultEmailService || "".equals(defaultEmailService))) {
			if (!defaultEmailService.matches(EMAIL_SERVICE_REGULAR)) {
				model.addAttribute("errorMessage", "default email service format error");
				return VIEW_LINKMAN_FORMAT_ERROR;
			}
		}

		// First create voterGroup
		long authorId = ShiroUtils.getUserId();
		VoterGroup voterGroup = new VoterGroup(authorId, voterGroupAndVoters.getGroupDescription());
		int voterGroupId = voterGroupService.createVoterGroup(voterGroup);

		String votersText = voterGroupAndVoters.getVoterText();

		String email = null;
		String alias = null;
		String[] linkmans = votersText.split(SEPARATOR_LINKMAN);

		for (int i = 0; i < linkmans.length; i++) {
			String linkman = linkmans[i];
			String[] linkmanInfo = linkman.split(SEPARATOR_USERNAME_ALIAS);
			int linkmanInfoLength = linkmanInfo.length;

			String emailOrEmailUserName = linkmanInfo[0];

			if (emailOrEmailUserName.matches(EMAIL_USERNAME_REGULAR)) {
				if (null == defaultEmailService) {
					continue;
				}

				email = emailOrEmailUserName + defaultEmailService;
			} else {
				email = emailOrEmailUserName;
			}

			if (linkmanInfoLength >= 2) {
				alias = linkmanInfo[1];
			}

			Voter voter = new Voter(voterGroupId, email, alias);
			// insert voters
			voterService.insertVoter(voter);
		}

		return VIEW_USER_MY_LINKMAN;
	}

	public static final String FORM_UPDATE_USER_BASE_INFO = "/user/updateUserBaseInfo.do";

	@RequestMapping(value = { FORM_UPDATE_USER_BASE_INFO }, method = RequestMethod.POST)
	public String updateUserBaseInfoAction(@ModelAttribute("userBaseInfo") UserBaseInfo userBaseInfo, Model model) {

		UserToken userToken = new UserToken(userBaseInfo.getEmail(), userBaseInfo.getPassword());
		boolean isMatched = authorService.authentication(userToken);
		if (!isMatched) {
			model.addAttribute("errorMessagePassword", "password error");
		}

		if (!userBaseInfo.getNewPassword().equals(userBaseInfo.getReNewPassword())) {
			model.addAttribute("errorMessageNewPassword", "new password not same");
		}

		userBaseInfo.setId(ShiroUtils.getUserId());
		authorService.updateBaseInfo(userBaseInfo);
		return VIEW_USER_PROFILE;
	}

	public static final String FORM_UPDATE_USER_DETAIL_INFO = "/user/updateUserDetailInfo.do";

	@RequestMapping(value = FORM_UPDATE_USER_DETAIL_INFO, method = RequestMethod.POST)
	public String updateDetailProfile(Object model) {

		// TODO

		return VIEW_USER_PROFILE;
	}

}
