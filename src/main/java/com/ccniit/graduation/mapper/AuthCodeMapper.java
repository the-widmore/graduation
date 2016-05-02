package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

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
	@SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = {
			"SELECT LAST_INSERT_ID() AS id" })
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

	/**
	 * 获取Vote的验证码，参数是vote和voter
	 * 
	 * @param Vote.id
	 * @param Voter.id
	 * @return AuthCode.code
	 */
	@Select("SELECT code FROM auth_code WHERE vote=#{vote} AND voter=#{voter}")
	String selectAuthCode(@Param("vote") long vote, @Param("voter") long voter);

	@Select("SELECT code FROM auth_code WHERE vote=#{vote}")
	String selectProtectedVoteAuthCode(@Param("vote") long vote);

	/**
	 * 将一个验证码设置为使用过
	 * 
	 * @param Vote.id
	 * @param Voter.id
	 * 
	 * @return affected rows
	 */
	@Update("UPDATE auth_code SET used=1 WHERE vote =#{vote} AND voter=#{voter}")
	Integer setAuthCodeUsed(@Param("vote") long vote, @Param("voter") long voter);

}
