package com.ccniit.graduation.convertor;

import javax.annotation.Resource;

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

	@Override
	public VoteVo convert(Vote vote) {
		VoteVo voteVo = new VoteVo();

		//id
		voteVo.setId(vote.getId());

		// title
		voteVo.setTitle(vote.getTitle());

		// progress
		voteVo.setProgress(VoteResource.getProgressMsg(vote.getProgress()));

		// tags
		voteVo.setTags(voteTagService.selectTagsToArray(vote.getId()));

		// inDate
		voteVo.setInDate(DateUtils.y4M2d2h2m2(vote.getInDate()));

		return voteVo;
	}

}
