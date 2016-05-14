package com.ccniit.graduation.resource;

/**
 * 缓存的内容
 */
public interface CacheNames {

	/** 用户信息缓存 */
	public static final String AUTHOR = "AuthorCache";
	/** 用户内容计数器缓存 */
	public static final String AUTHOR_VOTE_COUNT = "AuthorContentCounterCache";
	/** Vote缓存 */
	public static final String VOTE = "VoteCache";
	/** VoteVo缓存 */
	public static final String VOTE_VO = "VoteVoCache";
	/** 联系人缓存 */
	public static final String VOTER = "VoterCache";
	/** VoteTag缓存 */
	public static final String VOTE_TAG = "VoteTagCache";
	/** 资源权限缓存 */
	public static final String PERMISSION = "PermissionCache";
	/** 分页信息缓存 */
	public static final String PAGE_INFO = "PageInfo";

}
