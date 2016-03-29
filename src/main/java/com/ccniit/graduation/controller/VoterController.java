package com.ccniit.graduation.controller;

import java.util.Arrays;
import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.service.VoterService;
import com.ccniit.graduation.util.LoggerUtils;

/**
 * Voter 管理控制器
 */
@RestController
@RequestMapping("voter")
public class VoterController {

	private static final Logger DEV = LoggerUtils.getDev();

	@Resource
	VoterService voterService;

	@RequestMapping("updateEmail")
	public Callable<String> updateVoterField(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "value", required = true) String value) {
		String[] voterInfo = StringUtils.split(id, "_");
		
		DEV.debug(Arrays.toString(voterInfo));
		
		final Long voter = Long.parseLong(voterInfo[1]);
		final Voter.VoterField field = Voter.voterField(voterInfo[2]);

		DEV.debug(value);
		// TODO
		return new Callable<String>() {

			@Override
			public String call() throws Exception {
				return voterService.updateVoterField(field, voter);
			}
		};
	}

	@RequestMapping("/loadEmail")
	public String loadVoterEmail() {
		return "new@gmail.com";
	}

}
