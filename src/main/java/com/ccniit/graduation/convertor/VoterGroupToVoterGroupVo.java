package com.ccniit.graduation.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.pojo.db.VoterGroup;
import com.ccniit.graduation.pojo.vo.VoterGroupVo;
import com.ccniit.graduation.util.DateUtils;

@Component("voterGroupToVoterGroupVo")
public class VoterGroupToVoterGroupVo implements Converter<VoterGroup, VoterGroupVo> {

	VoterGroupVo vo = null;

	@Override
	public VoterGroupVo convert(VoterGroup source) {
		vo = new VoterGroupVo();
		vo.setId(source.getId());
		vo.setDescription(source.getDescription());
		vo.setQuantity(source.getQuantity());
		vo.setInDate(DateUtils.y4M2d2(source.getInDate()));
		return vo;
	}

}
