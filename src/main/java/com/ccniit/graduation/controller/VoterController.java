package com.ccniit.graduation.controller;

import java.util.Arrays;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

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

	@RequestMapping(value = "updateVoterField", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateVoterField(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "value", required = true) String value) throws IException {

		String[] voterInfo = StringUtils.split(id, "_");

		DEV.info(Arrays.toString(voterInfo));
		DEV.info("value:" + value);

		final Long voterId = Long.parseLong(voterInfo[1]);
		final Voter.VoterField field = Voter.voterField(voterInfo[2]);

		// 权限检查
		permissionService.voterHavePermission(ShiroUtils.getUserId(), voterId);

		boolean isValidated = false;
		switch (field) {
		case email:
			isValidated = vaildateFactory.vaildate(StringVaildateType.EMAIL, value);
			break;
		case phone:
			isValidated = vaildateFactory.vaildate(StringVaildateType.PHONE, value);
			break;
		case alias:
			value = StringUtils.left(value, 10);
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

	@RequestMapping(value = "/loadVoterField", method = { RequestMethod.GET, RequestMethod.POST })
	public String loadVoterEmail(@RequestParam("id") String id, @RequestParam("value") String value, WebRequest request)
			throws IException {

		DEV.info(request.getParameterMap().toString());

		String[] voterInfo = id.split("_");
		VoterField voterField = Voter.voterField(voterInfo[2]);
		long voterId = Long.parseLong(voterInfo[1]);

		permissionService.voterHavePermission(ShiroUtils.getUserId(), voterId);

		return voterService.getVoterField(voterField, voterId);
	}

}
