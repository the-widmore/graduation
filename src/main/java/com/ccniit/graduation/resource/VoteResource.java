package com.ccniit.graduation.resource;

import java.util.HashMap;
import java.util.Map;

public class VoteResource {

	private static final Map<Integer, String> PROGRESS_MAP = new HashMap<>();
	private static final Map<Integer, String> ACTIONS_MAP = new HashMap<>();

	static {
		// Progress
		PROGRESS_MAP.put(new Integer(VoteResource.CREATED), VoteResource.CREATED_MSG);
		PROGRESS_MAP.put(new Integer(VoteResource.EDITED), VoteResource.EDITED_MSG);
		PROGRESS_MAP.put(new Integer(VoteResource.PUBLISTED), VoteResource.PUBLISTED_MSG);
		PROGRESS_MAP.put(new Integer(VoteResource.FINISHED), VoteResource.FINISHED_MSG);
		// Action
		ACTIONS_MAP.put(new Integer(VoteResource.CREATED), VoteResource.CREATED_ACTION);
		ACTIONS_MAP.put(new Integer(VoteResource.EDITED), VoteResource.EDITED_ACTION);
		ACTIONS_MAP.put(new Integer(VoteResource.PUBLISTED), VoteResource.PUBLISHED_ACTION);
		ACTIONS_MAP.put(new Integer(VoteResource.FINISHED), VoteResource.FINISHED_ACTION);

	}

	public static enum VoteCategory {
		vote, poll, info
	}

	// 进度
	public static final int CREATED = 0;
	public static final int EDITED = 10;
	public static final int PUBLISTED = 20;
	public static final int FINISHED = 30;

	// 进度消息
	private static final String CREATED_MSG = "被创建";
	private static final String EDITED_MSG = "被定义";
	private static final String PUBLISTED_MSG = "被发布";
	private static final String FINISHED_MSG = "完结了";

	// 操作
	private static final String CREATED_ACTION = "编辑";
	private static final String EDITED_ACTION = "编辑";
	private static final String PUBLISHED_ACTION = "查看";
	private static final String FINISHED_ACTION = "导出";

	// 获取进度消息
	public static String getProgressMsg(int progress) {
		return PROGRESS_MAP.get(progress);
	}

	public static String getAction(int progress) {
		return ACTIONS_MAP.get(progress);
	}

}
