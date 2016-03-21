package com.ccniit.graduation.plus.poi;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseQueue {

	private static final Logger LOG = LoggerFactory.getLogger(ParseQueue.class);

	// Thread safe
	private volatile static List<String> queue = new LinkedList<>();
	private static boolean parsing;

	@Resource
	VoterParse parseVotersFromExcel;

	public void add(String path) {
		synchronized (queue) {
			queue.add(path);
		}
	}

	// TODO task
	public void start() {

		if (parsing) {
			return;
		}

		// TODO

	}

}
