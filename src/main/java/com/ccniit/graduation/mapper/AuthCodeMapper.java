package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.ccniit.graduation.pojo.db.AuthCode;

/**
 * 验证码接口
 */
public interface AuthCodeMapper {

	/**
	 * 插入一个验证码
	 * 
	 * @param authCode
	 * @return 成功插入的记录的ID
	 * 
	 */
	@Insert("INSERT INTO auth_code(vote,voter,code) VALUES (#{vote},#{voter},#{code})")
	Long insertAuthCode(AuthCode code);

	/**
	 * 删除一个Vote的全部验证码
	 * 
	 * @param Vote.id
	 * @return 成功删除的条数
	 * 
	 */
	@Delete("DELETE FROM auth_code WHERE vote=#{vote}")
	Integer deleteAuthCodes(long vote);

}
