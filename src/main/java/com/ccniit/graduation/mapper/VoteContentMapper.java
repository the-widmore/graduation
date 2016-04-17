package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.ccniit.graduation.pojo.db.VoteContent;

/**
 * 提供问题定义的Create/Update/Select
 */
public interface VoteContentMapper {

	@Insert("INSERT INTO vote_content(id,content) VALUES(#{id},#{content})")
	@SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = {
			"SELECT LAST_INSERT_ID() AS id" })
	Long insertVoteContent(VoteContent content);

	@Select("SELECT content FROM vote_content WHERE id=#{vote}")
	String selectVoteContent(long vote);

	@Select("UPDATE vote_content SET content=#{content} WHERE id=#{id}")
	Integer updateVoteContent(VoteContent newContent);

}
