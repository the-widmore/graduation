package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mysql.AuthCodeDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.AuthCode;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.db.Vote.AuthType;
import com.ccniit.graduation.service.AuthCodeService;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.StringUtils;

@Service("authCodeService")
public class AuthCodeServiceImpl implements AuthCodeService {

	@Resource
	AuthCodeDao authCodeDao;
	@Resource
	VoteService voteService;

	@Override
	public void generateVoteAuthCode(Long voteId) throws IException {
		Vote vote = voteService.selectVote(voteId);
		AuthType authType = Vote.AuthType.valueOf(vote.getAuth());

		switch (authType) {
		case PROTECTED:
			authCodeDao.insertAuthCode(new AuthCode(voteId, null, StringUtils.getPassword(6)));
			break;
		case PRIVATE:
			// TODO
			break;
		default:
			break;
		}

	}

	@Override
	public String getProtectedAuthCode(Long voteId) {
		// TODO Auto-generated method stub
		return null;
	}

}
