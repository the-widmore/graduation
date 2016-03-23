package com.ccniit.graduation.plus.poi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.common.VoterGroupData;
import com.ccniit.graduation.service.VoterService;
import com.ccniit.graduation.util.LoggerUtils;

public class ParseQueue {

	private static final Logger LOG = LoggerUtils.getDev();

	// Thread safe
	private volatile static List<String> queue = new LinkedList<>();
	private static boolean parsing;

	@Resource
	VoterParse parseVotersFromExcel;
	@Resource
	VoterService voterService;

	public void add(String path) {
		synchronized (queue) {
			queue.add(path);
		}
	}

	// TODO task
	public void start() throws IException {

		if (parsing) {
			return;
		}

		parsing = true;
		for (Iterator<String> iterator = queue.iterator(); iterator.hasNext();) {
			String path = iterator.next();

			LOG.debug(path);

			String[] params = { path };

			VoterGroupData voterGroup = parseVotersFromExcel.parse(params);
			// TODO
			voterService.insertVoters(voterGroup.getVoters());
		}

		parsing = false;

		// TODO

	}

}
