package com.ccniit.graduation.builder;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ccniit.graduation.dao.mongodb.IVoteDataDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.vo.VoteSummaryVo;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.DateUtils;

@Component("voteSummaryVoBuilder")
public class VoteSummaryVoBuilder implements Builder<Long, VoteSummaryVo> {

	@Resource
	VoteService voteService;
	@Resource
	IVoteDataDao voteDataDao;

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
		voteSummaryVo.setAuth(getVoteAuthInfo(by));

		return voteSummaryVo;
	}

	private String getVoteAuthInfo(Long vote) {
		return null;
	}

}
