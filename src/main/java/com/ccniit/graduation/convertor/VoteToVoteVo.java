package com.ccniit.graduation.convertor;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.VoteResource;
import com.ccniit.graduation.service.VoteTagService;
import com.ccniit.graduation.util.DateUtils;

@Component("voteToVoteVo")
public class VoteToVoteVo implements Converter<Vote, VoteVo> {

	@Resource
	VoteTagService voteTagService;

	VoteVo voteVo = new VoteVo();

	@Override
	public VoteVo convert(Vote vote) {
		voteVo.setTitle(vote.getTitle());

		voteVo.setProgress(VoteResource.getProgressMsg(vote.getProgress()));

		String tags = voteTagService.selectTags(vote.getId());
		if (null == tags) {
			voteVo.setTags(StringUtils.EMPTY);
		} else {
			voteVo.setTags(tags);
		}

		voteVo.setInDate(DateUtils.y4M2d2h2m2(vote.getInDate()));

		Date endDate = new Date();
		if (VoteResource.FINISHED == vote.getProgress()) {
			endDate = vote.getEndDate();
		} else {
			endDate = vote.getPredictDate();
		}
		voteVo.setEndDate(DateUtils.y4M2d2h2m2(endDate));

		return voteVo;
	}

}
