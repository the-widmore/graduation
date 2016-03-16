package com.ccniit.graduation.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccniit.graduation.pojo.common.DataGrid;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.qo.VoterQuery;
import com.ccniit.graduation.service.VoterGroupService;

@Controller
public class EasyUIDataController {

	@Resource
	VoterGroupService voterGroupService;

	private static final String USER_VOTER_GROUP_DETAIL_URL = "/easyui/voterGroupDetail/{groupId}?";

	@RequestMapping(value = USER_VOTER_GROUP_DETAIL_URL, method = RequestMethod.GET)
	@ResponseBody
	public DataGrid<?> getVoterGroupDetail(@PathVariable("groupId") long groupId,
			@RequestParam(required = true, defaultValue = "0") int page) {
		VoterQuery voterQuery = new VoterQuery(groupId, page);
		List<Voter> voters = voterGroupService.getVotersByVoterGroupIdAndPage(voterQuery);

		DataGrid<Voter> dataGridVoters = new DataGrid<>(voters.size(), voters);
		return dataGridVoters;
	}

}
