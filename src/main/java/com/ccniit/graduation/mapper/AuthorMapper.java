package com.ccniit.graduation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.vo.EmailToken;

public interface AuthorMapper {

	/**
	 * 插入一条新的Author记录
	 * 
	 * @param author
	 * @return author.id
	 */
	@Insert("INSERT INTO author(email,password,nickname) VALUES(#{email},#{password},#{nickname})")
	@SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = {
			"SELECT LAST_INSERT_ID() AS id" })
	Long insertAuthor(Author author);

	/**
	 * 按照id查询一条Author记录
	 * 
	 * @param author.id
	 * @return author
	 */
	@Select("SELECT email,phone,name,nickName,sex,status FROM author WHERE id=#{id}")
	Author selectById(long id);

	/**
	 * 按照email查询Author的id
	 */
	@Select("SELECT id FROM author WHERE email=#{email}")
	Long selectAuthorIdByEmail(String email);

	/**
	 * 按照email查询一条Author记录
	 * 
	 * @param author.email
	 * @return author
	 */
	@Select("SELECT email,phone,name,nickName,sex,status FROM author WHERE email=#{email}")
	Author selectAuthorByEmail(String email);

	/**
	 * 修改Author的基本信息，不包括密码
	 * 
	 * @param Author
	 * @return affected rows
	 */
	@Update("UPDATE author SET phone=#{phone},name=#{name},nickName=#{nickName},sex=#{sex} WHERE id=#{id}")
	int updateAuthorWithoutPassword(Author author);

	/**
	 * 按照id更新一条Author的密码
	 * 
	 * @param author
	 * @return affected rows
	 */
	@Update("UPDATE author SET password=#{password} WHERE id=#{id}")
	int updateAuthorPassword(Author author);

	/**
	 * 按照id更新Author的二级密
	 * 
	 * @param author
	 * @return affected rows
	 */
	@Update("UPDATE author SET secondPassword=#{secondPassword} WHERE id=#{id}")
	int updateAuthorSecondPassword(Author author);

	/**
	 * 统计Email在Author中的记录条数
	 * 
	 * @param email
	 * @return email存在的条数
	 */
	@Select("SELECT COUNT(email) FROM author WHERE email=#{email}")
	int countByEmail(String email);

	/**
	 * 查询Author的登录信息
	 * 
	 * @param author.email
	 * @return author凭证，邮箱和密码
	 */
	@Select("SELECT email,password FROM author WHERE email=#{email}")
	EmailToken selectAuthorEmailToken(String email) throws IException;

}
