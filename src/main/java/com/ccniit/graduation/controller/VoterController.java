package com.ccniit.graduation.controller;

import java.util.Arrays;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.db.Voter.VoterField;
import com.ccniit.graduation.service.PermissionService;
import com.ccniit.graduation.service.VoterService;
import com.ccniit.graduation.util.LoggerUtils;
import com.ccniit.graduation.util.ShiroUtils;
import com.ccniit.graduation.validator.StringVaildateFactory;
import com.ccniit.graduation.validator.StringVaildateFactory.StringVaildateType;

/**
 * Voter 管理控制器
 */
@RestController
@RequestMapping("voter")
public class VoterController {

	private static final Logger DEV = LoggerUtils.getDev();

	@Resource
	VoterService voterService;
	@Resource
	StringVaildateFactory vaildateFactory;
	@Resource
	PermissionService permissionService;

	@RequestMapping(value = "updateEmail", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateVoterField(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "value", required = true) String value) throws IException {

		String[] voterInfo = StringUtils.split(id, "_");

		DEV.info(Arrays.toString(voterInfo));

		final Long voterId = Long.parseLong(voterInfo[1]);
		final Voter.VoterField field = Voter.voterField(voterInfo[2]);

		// 权限检查
		boolean havePermission = permissionService.voterHavePermission(ShiroUtils.getUserId(), voterId);
		if (!havePermission) {
			return "You have not permission!";
		}

		boolean isValidated = false;
		switch (field) {
		case email:
			isValidated = vaildateFactory.vaildate(StringVaildateType.EMAIL, value);
			break;
		case phone:
			isValidated = vaildateFactory.vaildate(StringVaildateType.PHONE, value);
			break;
		case alias:
			value = value.substring(0, 4);
			isValidated = true;
			break;
		default:
			break;
		}

		if (!isValidated) {

			DEV.warn("format error,can not be change!");

			return voterService.getVoterField(field, voterId);
		}

		DEV.info(value);
		return voterService.updateVoterField(field, voterId, value);
	}

	@RequestMapping("/loadVoterField")
	public String loadVoterEmail(@RequestParam("id") String id, @RequestParam("value") String value) throws IException {

		String[] voterInfo = id.split("_");
		VoterField voterField = Voter.voterField(voterInfo[2]);
		long voterId = Long.parseLong(voterInfo[1]);

		return voterService.getVoterField(voterField, voterId);
	}

}
