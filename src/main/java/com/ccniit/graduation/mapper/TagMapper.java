package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface TagMapper {

	/***
	 * 插入Tag,返回Tag.id
	 * 
	 * @param tag
	 * @return Tag.id
	 */
	@Insert("INSERT INTO tag(tag) VALUES(#{tag})")
	@SelectKey(before = false, keyProperty = "", resultType = Integer.class, statement = {
			"SELECT LAST_INSERT_ID() AS id" })
	Integer insertTag(String tag);

	/**
	 * 查询tag的id
	 * 
	 * @param tag
	 * @return id
	 */
	@Select("SELECT id FROM tag WHERE tag=#{tag}")
	Integer selectTagId(String tag);

}
