package com.ccniit.graduation.service;

import com.ccniit.graduation.exception.IException;

public interface AuthCodeService {

	/**
	 * 生成授权码
	 */
	void generateVoteAuthCode(Long voteId) throws IException;

	/**
	 * 获取受保护类型Vote的授权码
	 */
	String getProtectedAuthCode(Long voteId) throws IException;

	/**
	 * 根据Vote.id和一个Email获取私有Vote对应的授权码
	 */
	String getPrivatedAuthCode(Long voteId, String email) throws IException;

}
