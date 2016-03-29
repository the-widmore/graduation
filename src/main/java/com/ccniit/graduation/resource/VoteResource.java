package com.ccniit.graduation.resource;

import java.util.HashMap;
import java.util.Map;

public class VoteResource {

	private static final Map<Integer, String> PROGRESS_MAP = new HashMap<>();

	static {
		PROGRESS_MAP.put(new Integer(VoteResource.CREATED), VoteResource.CREATED_MSG);
		PROGRESS_MAP.put(new Integer(VoteResource.EDITED), VoteResource.EDITED_MSG);
		PROGRESS_MAP.put(new Integer(VoteResource.PUBLISTED), VoteResource.PUBLISTED_MSG);
		PROGRESS_MAP.put(new Integer(VoteResource.PROCEES), VoteResource.PROCEES_MSG);
		PROGRESS_MAP.put(new Integer(VoteResource.FINISHED), VoteResource.FINISHED_MSG);

	}

	public static enum Category {
		vote, poll, info
	}

	// 进度
	public static final int CREATED = 0;
	public static final int EDITED = 10;
	public static final int PUBLISTED = 20;
	public static final int PROCEES = 30;
	public static final int FINISHED = 40;

	// 进度消息
	public static final String CREATED_MSG = "被创建";
	public static final String EDITED_MSG = "被定义";
	public static final String PUBLISTED_MSG = "被发布";
	public static final String PROCEES_MSG = "进行中";
	public static final String FINISHED_MSG = "完结了";

	// 获取进度消息
	public static String getProgressMsg(int progress) {
		return PROGRESS_MAP.get(progress);
	}

}
