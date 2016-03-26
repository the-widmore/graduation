package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ccniit.graduation.pojo.db.AuthorInfo;
import com.ccniit.graduation.pojo.qo.AuthorUpdater;

/**
 * Author的扩展信息操作接口
 */
public interface AuthorInfoMapper {

	// TODO

	@Insert("INSERT INTO author_info(id) VALUES(#{author})")
	Integer insertEmptyAuthorInfo(long author);

	@Update("")
	Integer updateAuthorInfo(AuthorUpdater authorUpdater);

	@Select("")
	AuthorInfo selectAuthorInfo(long author);

}
