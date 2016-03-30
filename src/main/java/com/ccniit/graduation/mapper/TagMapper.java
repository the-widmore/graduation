package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.ccniit.graduation.pojo.db.VoteTag;

public interface TagMapper {

	/***
	 * 插入Tag,返回Tag.id
	 * 
	 * @param tag
	 * @return Tag.id
	 */
	@Insert("INSERT INTO tag(tag) VALUES(#{tag})")
	@SelectKey(before = false, keyProperty = "", resultType = Long.class, statement = {
			"SELECT LAST_INSERT_ID() AS id" })
	Long insertTag(VoteTag VoteTag);

	/**
	 * 查询tag的id
	 * 
	 * @param tag
	 * @return id
	 */
	@Select("SELECT id FROM tag WHERE tag=#{tag}")
	Long selectTagId(String tag);

}
