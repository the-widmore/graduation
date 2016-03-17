package com.ccniit.graduation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ccniit.graduation.pojo.qo.VoteQuery;
import com.ccniit.graduation.pojo.vo.VoteVo;

public interface VoteTagMapper {

	/**
	 * 
	 * */
	@Insert("")
	int insertVoteTag(String tag, long vote);

	/**
	 * 查询一个Vote的tags
	 * 
	 * @param vote.id
	 * @return tags
	 */
	@Select("")
	String selectVoteTag(long vote);

	/**
	 * 按照tag,搜索Vote。
	 *
	 * @param VoteQuery
	 * @return List<VoteVo>
	 */
	// TODO 分页
	@Select("")
	List<VoteVo> selectVotes(VoteQuery query);

}
