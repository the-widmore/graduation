package com.ccniit.graduation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ccniit.graduation.pojo.common.VoteCategoryCount;

public interface AuthorCountMapper {

	/**
	 * 统计Author的联系人组有多少个
	 * 
	 * @param auhtor.id
	 */
	@Select("SELECT COUNT(id) FROM voter_group WHERE author=#{authorId}")
	int countAuthorLinkmanGroup(long authorId);

	/**
	 * 统计Author的Vote每种有多少个，顺序为[vote,poll,info]
	 * 
	 * @param auhtor.id
	 */
	@Select("SELECT category,COUNT(id) AS counter FROM vote WHERE author=#{authorId} GROUP BY category")
	List<VoteCategoryCount> countAuthorVote(long authorId);

}
