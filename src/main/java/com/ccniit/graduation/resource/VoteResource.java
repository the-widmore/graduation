package com.ccniit.graduation.resource;

import java.util.HashMap;
import java.util.Map;

public class VoteResource {

	/** 刚被创建 */
	public static final int CREATED = 0;
	/** 被编辑过 */
	public static final int EDITED = 10;
	/** 被发不了 */
	public static final int PUBLISHED = 20;
	/** 已经结束 */
	public static final int FINISHED = 30;

	// Progress
	private static final String CREATED_MSG = "被创建";
	private static final String EDITED_MSG = "被定义";
	private static final String PUBLISHED_MSG = "被发布";
	private static final String FINISHED_MSG = "完结了";

	// Action
	private static final String CREATED_ACTION = "编辑";
	private static final String EDITED_ACTION = "编辑";
	private static final String PUBLISHED_ACTION = "查看";
	private static final String FINISHED_ACTION = "导出";

	private static Map<Integer, String> PROGRESS_MAP = new HashMap<>();
	private static Map<Integer, String> ACTION_MAP = new HashMap<>();

	static {
		PROGRESS_MAP.put(CREATED, CREATED_MSG);
		PROGRESS_MAP.put(EDITED, EDITED_MSG);
		PROGRESS_MAP.put(PUBLISHED, PUBLISHED_MSG);
		PROGRESS_MAP.put(FINISHED, FINISHED_MSG);

		ACTION_MAP.put(CREATED, CREATED_ACTION);
		ACTION_MAP.put(EDITED, EDITED_ACTION);
		ACTION_MAP.put(PUBLISHED, PUBLISHED_ACTION);
		ACTION_MAP.put(FINISHED, FINISHED_ACTION);
	}

	/**
	 * get progress message
	 * 
	 * @param progress
	 *            vote progress
	 * @return progress message
	 */
	public static String getProgressMsg(int progress) {
		return PROGRESS_MAP.get(progress);
	}

	/**
	 * get action message
	 * 
	 * @param progress
	 *            vote progress
	 * @return progress message
	 */
	public static String getAction(int progress) {
		return ACTION_MAP.get(progress);
	}

}
