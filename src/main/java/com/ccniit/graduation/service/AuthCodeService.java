package com.ccniit.graduation.service;

import com.ccniit.graduation.exception.IException;

public interface AuthCodeService {

	void generateVoteAuthCode(Long voteId) throws IException;

	String getProtectedAuthCode(Long voteId);

}
