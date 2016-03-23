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
	long insertAuthor(Author author);

	/**
	 * 按照id查询一条Author记录
	 * 
	 * @param author.id
	 * @return author
	 */
	@Select("SELECT email,tel,name,sex FROM author WHERE id=#{id}")
	Author selectById(long id);

	/**
	 * 按照email查询Author的id
	 */
	@Select("SELECT id FROM author WHERE email=#{email}")
	long selectAuthorIdByEmail(String email);

	/**
	 * 按照email查询一条Author记录
	 * 
	 * @param author.email
	 * @return author
	 */
	@Select("SELECT id,tel,nickname,name,sex,avatar FROM author WHERE email=#{email}")
	Author selectAuthorByEmail(String email);

	/**
	 * 更新一条author记录，按照id
	 * 
	 * @param author
	 * @return affected rows
	 */
	@Update("UPDATE author SET tel=#{tel},nickname=#{nickanem},name=#{name},sex=#{sex} WHERE id=#{id}")
	int updateAuthor(Author author);

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
