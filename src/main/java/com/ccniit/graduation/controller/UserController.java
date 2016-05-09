package com.ccniit.graduation.controller;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ccniit.graduation.convertor.AuthorToAuthorBaseUpdater;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.common.UserToken;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;
import com.ccniit.graduation.pojo.vo.UserRegister;
import com.ccniit.graduation.resource.Commons;
import com.ccniit.graduation.service.AuthorCountService;
import com.ccniit.graduation.service.AuthorService;
import com.ccniit.graduation.service.PermissionService;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.service.VoterGroupService;
import com.ccniit.graduation.service.VoterService;
import com.ccniit.graduation.util.LoggerUtils;
import com.ccniit.graduation.util.ShiroUtils;
import com.ccniit.graduation.util.SpringMVCUtils;

/**
 * 用户的基本控制器
 */
@Controller
@SessionAttributes("authorContentCounter")
public class UserController {

	private static final Logger DEV = LoggerUtils.getDev();

	@Resource
	private AuthorService authorService;
	@Resource
	private AuthorCountService authorCountService;
	@Resource
	private VoterService voterService;
	@Resource
	private VoteService voteService;
	@Resource
	private VoterGroupService voterGroupService;
	@Resource
	private PermissionService permissionService;
	@Resource
	private AuthorToAuthorBaseUpdater authorToAuthorBaseUpdater;

	protected static final String VIEW_USER_SIGN_IN = "/user/userSignIn.html";

	/**
	 * 用户注册页面
	 */
	@RequestMapping(value = { VIEW_USER_SIGN_IN }, method = RequestMethod.GET)
	public String userSignIn(ModelMap modelMap) {

		return VIEW_USER_SIGN_IN;
	}

	protected static final String FORM_USER_SIGN_IN = "/user/userSignIn.do";
	/**
	 * 注册成功
	 */
	protected static final String USER_SIGN_IN_RESULT = "/user/signInSuccess.html";

	/**
	 * 注册页面
	 */
	@RequestMapping(value = { FORM_USER_SIGN_IN }, method = RequestMethod.POST)
	public String signInAction(@ModelAttribute("userRegister") UserRegister userRegister, BindingResult result,
			Model model) throws Exception {

		String verifyCode = (String) ShiroUtils.getSessionValue(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

		DEV.info("verifyCode : " + verifyCode);

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

	protected static final String VIEW_USER_LOG_DEVIN = "/user/userLogin.html";

	/**
	 * 用户登录页面
	 */
	@RequestMapping(value = { VIEW_USER_LOG_DEVIN }, method = RequestMethod.GET)
	public String userLogin(Model model) throws IException {
		model.addAttribute("lastURL", ShiroUtils.getSessionValue(Commons.SESSION_KEY_LAST_URL));
		model.addAttribute("userToken", new UserToken());

		return VIEW_USER_LOG_DEVIN;
	}

	protected static final String VIEW_USER_LOGIN = "/user/userLogin.do";

	@RequestMapping(value = { VIEW_USER_LOGIN }, method = RequestMethod.POST)
	public String loginAction(@ModelAttribute("userToken") UserToken userToken, BindingResult result, Model model)
			throws IException {

		UsernamePasswordToken token = new UsernamePasswordToken(userToken.getEmail(), userToken.getPassword());
		Subject currentUser = ShiroUtils.getSubject();
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			model.addAttribute("message", "account or password error!");
			return VIEW_USER_LOG_DEVIN;
		}

		if (currentUser.isAuthenticated()) {
			Session session = currentUser.getSession(true);
			long id = authorService.getAuthorIdByEmail(userToken.getEmail());

			DEV.debug("Email:{} ID:{}", currentUser.getPrincipal(), id);

			session.setAttribute(Commons.SESSION_KEY_AUTHOR_ID, id);

			return SpringMVCUtils.redirect(VIEW_USER_SELF_CENTER);
		} else {
			model.addAttribute("message", "account or password error!");
			return VIEW_USER_LOG_DEVIN;
		}
	}

	protected static final String ACTION_LOG_DEVOUT_URL = "/user/logout.do";
	protected static final String ACTION_LOG_DEVOUT_RESULT = "../index";

	/**
	 * 注销
	 */
	@RequestMapping(value = { ACTION_LOG_DEVOUT_URL }, method = RequestMethod.GET)
	public String logoutAction(ModelMap modelMap) {
		modelMap.addAttribute("message", "Logout success!");

		try {
			Subject subject = ShiroUtils.getSubject();
			subject.getSession().stop();
			subject.logout();
		} catch (Exception e) {
			DEV.error("注销错误", e);
		}

		return SpringMVCUtils.redirect(ACTION_LOG_DEVOUT_RESULT);
	}

	protected static final String VIEW_USER = "/user";
	protected static final String VIEW_USER_SELF_CENTER = "/user/selfCenter.html";

	/**
	 * 用户个人中心
	 */
	@RequestMapping(value = { VIEW_USER_SELF_CENTER, VIEW_USER })
	public String selfCenter(ModelMap modelMap) throws IException {
		if (null == ShiroUtils.getSessionValue("authorContentCounter")) {
			AuthorContentCounter authorContentCounter = authorCountService.getAuthorCounters(ShiroUtils.getUserId());
			ShiroUtils.addAttribute("authorContentCounter", authorContentCounter);
		}
		return VIEW_USER_SELF_CENTER;
	}

	protected static final String VIEW_USER_USER_ACCOUNT = "/user/userAccount.html";

	/**
	 * 用户关联账号
	 */
	@RequestMapping(value = { VIEW_USER_USER_ACCOUNT }, method = RequestMethod.GET)
	public String userAccount(ModelMap modelMap) {

		return VIEW_USER_USER_ACCOUNT;
	}

	protected static final String VIEW_USER_CONSLOE = "/user/userConsole.html";

	/**
	 * 用户控制台
	 */
	@RequestMapping(value = { VIEW_USER_CONSLOE }, method = RequestMethod.GET)
	public String userConsole(ModelMap modelMap) {

		return VIEW_USER_CONSLOE;
	}

	protected static final String VIEW_USER_ORDER = "/user/userOrder.html";

	/**
	 * 用户订单(增值服务购买记录)
	 */
	@RequestMapping(value = { VIEW_USER_ORDER }, method = RequestMethod.GET)
	public String userOrder(ModelMap model) {

		return VIEW_USER_ORDER;
	}

}
