package com.ccniit.graduation.plus.poi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.service.VoterService;

public class ParseQueue {

	private static final Logger LOG = LoggerFactory.getLogger(ParseQueue.class);

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
			String[] params = { path };

			List<Voter> voters = parseVotersFromExcel.parse(params);

			voterService.insertVoters(voters);
		}

		parsing = false;

		// TODO

	}

}
