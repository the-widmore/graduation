package com.ccniit.graduation.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.ccniit.graduation.service.AuthorService;
import com.ccniit.graduation.util.ShiroUtils;

/**
 * 用户账号管理相关的控制器
 */
@Controller
public class UserAccountController {

	// profile ###########

	@Resource
	AuthorService authorService;
	@Resource
	AuthorToAuthorBaseUpdater authorToAuthorBaseUpdater;

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

}
