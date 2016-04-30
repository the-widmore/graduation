package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ccniit.graduation.pojo.db.AuthorInfo;
import com.ccniit.graduation.pojo.qo.AuthorInfoUpdater;
import com.ccniit.graduation.pojo.qo.AuthorSettingUpdater;

/**
 * Author的扩展信息操作接口
 */
public interface AuthorInfoMapper {

	@Insert("INSERT INTO author_info(id) VALUES(#{author})")
	Integer insertEmptyAuthorInfo(long author);

	@Update("UPDATE author_info SET address=#{address},work=#{work},company=#{company},descriptionSelf=#{descriptionSelf} WHERE id=#{id}")
	Integer updateAuthorInfo(AuthorInfoUpdater updater);

	@Update("UPDATE author_info SET setLinkmanNotify=#{setLinkmanNotify},setVoteFinishNotify=#{setVoteFinishNotify},setDataExpireNotify=#{setDataExpireNotify},setPrimaryNofify=#{setPrimaryNofify} WHERE id=#{id};")
	Integer updateAuthorSetting(AuthorSettingUpdater updater);

	@Select("SELECT * FROM author WHERE id=#{author}")
	AuthorInfo selectAuthorInfo(long author);

}
