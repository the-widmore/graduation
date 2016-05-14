package com.ccniit.graduation.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccniit.graduation.convertor.AuthorToAuthorBaseUpdater;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.ServerException;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.qo.AuthorBaseUpdater;
import com.ccniit.graduation.pojo.qo.AuthorInfoUpdater;
import com.ccniit.graduation.pojo.qo.AuthorSettingUpdater;
import com.ccniit.graduation.service.AuthorService;
import com.ccniit.graduation.util.ShiroUtils;
import com.ccniit.graduation.util.SpringMVCUtils;

/**
 * 用户账号管理相关的控制器
 */
@Controller
public class UserAccountController {

	@Resource
	private AuthorService authorService;
	@Resource
	private AuthorToAuthorBaseUpdater authorToAuthorBaseUpdater;

	// profile ###########

	/**
	 * 用户信息URL和视图位置
	 */
	protected static final String VIEW_USER_PROFILE = "/user/userProfile.html";

	// 查看用户资料
	@RequestMapping(value = { VIEW_USER_PROFILE }, method = RequestMethod.GET)
	public String userProfile(@ModelAttribute("baseUpdater") AuthorBaseUpdater baseUpdater,
			@ModelAttribute("infoUpdater") AuthorInfoUpdater infoUpdater, Model model, BindingResult result)
			throws IException {

		if (result.hasErrors()) {
			throw new ServerException("");
		}

		Author author = authorService.findAuthorById(ShiroUtils.getUserId());
		baseUpdater = authorToAuthorBaseUpdater.convert(author);

		// TODO set userDetailInfo value

		model.addAttribute("baseUpdater", baseUpdater);
		model.addAttribute("infoUpdater", infoUpdater);

		return VIEW_USER_PROFILE;
	}

	// ########### profile

	protected static final String FORM_UPDATE_USER_BASE_INFO = "/user/updateUserBaseInfo.do";

	@RequestMapping(value = { FORM_UPDATE_USER_BASE_INFO }, method = RequestMethod.POST)
	public String updateUserBaseInfoAction(@ModelAttribute("baseUpdater") AuthorBaseUpdater baseUpdater, Model model)
			throws IException {
		baseUpdater.setId(ShiroUtils.getUserId());
		int result = authorService.updateAuthorBase(baseUpdater);

		switch (result) {
		case AuthorService.PASSWORD_ERROR:
			model.addAttribute("msg", "密码错误");
			break;
		case AuthorService.UPDATE_SUCCESS:
			model.addAttribute("msg", "成功");
			return SpringMVCUtils.redirect(UserAccountController.VIEW_USER_PROFILE);
		case AuthorService.PASSWORD_NOT_SAME:
			model.addAttribute("msg", "新密码和确认不一致");
			break;
		default:
			break;
		}
		return SpringMVCUtils.redirect(UserAccountController.VIEW_USER_PROFILE);
	}

	protected static final String FORM_UPDATE_USER_DETAIL_INFO = "/user/updateUserDetailInfo.do";

	@RequestMapping(value = FORM_UPDATE_USER_DETAIL_INFO, method = RequestMethod.POST)
	public String updateDetailProfile(Model model) {

		// TODO

		return UserAccountController.VIEW_USER_PROFILE;
	}

	protected static final String VIEW_USER_USER_ACCOUNT = "/user/userAccount.html";

	@RequestMapping(value = { VIEW_USER_USER_ACCOUNT }, method = RequestMethod.GET)
	public String userAccount(ModelMap modelMap) {

		return VIEW_USER_USER_ACCOUNT;
	}

	protected static final String VIEW_USER_CONSLOE = "/user/userConsole.html";

	@RequestMapping(value = { VIEW_USER_CONSLOE }, method = RequestMethod.GET)
	public String userConsole(ModelMap modelMap) {

		return VIEW_USER_CONSLOE;
	}

	protected static final String UPDATE_USER_SET_DO = "/user/updateSetting.do";

	@RequestMapping(value = UPDATE_USER_SET_DO, method = RequestMethod.POST)
	public String updateSetting(@ModelAttribute("updater") AuthorSettingUpdater updater, Model model) {
		// TOOD 修改用户设置
		return null;
	}

	protected static final String VIEW_USER_ORDER = "/user/userOrder.html";

	@RequestMapping(value = { VIEW_USER_ORDER }, method = RequestMethod.GET)
	public String userOrder(ModelMap model) {

		return VIEW_USER_ORDER;
	}

}
