package com.ccniit.graduation.builder;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ccniit.graduation.dao.mongodb.IVoteDataDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.db.Vote.AuthType;
import com.ccniit.graduation.pojo.vo.VoteSummaryVo;
import com.ccniit.graduation.service.AuthCodeService;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.DateUtils;

@Component("voteSummaryVoBuilder")
public class VoteSummaryVoBuilder implements Builder<Long, VoteSummaryVo> {

	@Resource
	VoteService voteService;
	@Resource
	IVoteDataDao voteDataDao;
	@Resource
	AuthCodeService authCodeService;

	@Override
	public VoteSummaryVo build(Long by) throws IException {
		Vote vote = voteService.selectVote(by);

		Date predictDate = vote.getPredictDate();

		VoteSummaryVo voteSummaryVo = new VoteSummaryVo();
		voteSummaryVo.setCreateTime(DateUtils.y4M2d2h2m2(vote.getInDate()));
		voteSummaryVo.setSurplusTime(DateUtils.betweenNow(predictDate));
		voteSummaryVo.setEndTime(DateUtils.y4M2d2h2m2(predictDate));
		voteSummaryVo.setLastSubmitTime("last submit date");// TODO
		voteSummaryVo.setSubmitTimes(String.valueOf(voteDataDao.counterVoteSubmitTimes(vote.getTableName())));
		voteSummaryVo.setAuth(getVoteAuthInfo(vote));

		return voteSummaryVo;
	}

	private String getVoteAuthInfo(Vote vote) throws IException {
		String auth = vote.getAuth();
		AuthType authEnum = AuthType.valueOf(auth);

		String authInfo = null;
		switch (authEnum) {
		case PROTECTED:
			String code = authCodeService.getProtectedAuthCode(vote.getId());
			authInfo = "保护".concat("/").concat(code);
			break;
		case PRIVATE:
			authInfo = "私有";
			break;
		case PUBLIC:
			authInfo = "公开";
			break;
		default:
			break;
		}

		return authInfo;
	}

}
