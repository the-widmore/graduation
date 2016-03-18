package com.ccniit.graduation.service;

public interface TagService {

	/**
	 * 插入投票的标签，返回该记录的id
	 * 
	 * @param 一个标签
	 * @return Tag.id
	 */
	int insertTagForVote(String tag);

}
