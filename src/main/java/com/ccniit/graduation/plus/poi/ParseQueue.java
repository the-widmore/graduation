package com.ccniit.graduation.plus.poi;

import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.Resource;

import org.slf4j.Logger;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.common.VoterGroupData;
import com.ccniit.graduation.pojo.db.VoterGroup;
import com.ccniit.graduation.service.VoterGroupService;
import com.ccniit.graduation.service.VoterService;
import com.ccniit.graduation.util.LoggerUtils;

public class ParseQueue {

	private static ConcurrentLinkedQueue<ExcelVoterParseTask> queue = new ConcurrentLinkedQueue<>();

	private static final Logger LOG = LoggerUtils.getDev();

	@Resource
	VoterParse parseVotersFromExcel;
	@Resource
	VoterGroupService voterGroupService;
	@Resource
	VoterService voterService;

	public void parse() throws IException {
		if (queue.isEmpty()) {
			return;
		} else {
			// 获取任务
			ExcelVoterParseTask task = queue.poll();

			VoterGroupData voterGroupData = parseVotersFromExcel.parse(task.getExcelPath());
			VoterGroup voterGroup = new VoterGroup(task.getAuthor(), voterGroupData.getVoterGroupDescription());
			Long voterGroupId = voterGroupService.createVoterGroup(voterGroup);
			int voterCounter = voterService.insertVoters(voterGroupData.getVoters(), voterGroupId);

			LOG.debug("{} have {} voters", task.getExcelPath(), voterCounter);
		}
	}

}
