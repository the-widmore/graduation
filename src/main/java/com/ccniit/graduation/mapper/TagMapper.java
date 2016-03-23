package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TagMapper {

	@Select("SELECT COUNT(id) FROM tag WHERE tag=#{tag}")
	int countTag(String tag);

	@Insert("INSERT INTO tag(tag) VALUES(#{tag})")
	int insertTag(String tag);

}
