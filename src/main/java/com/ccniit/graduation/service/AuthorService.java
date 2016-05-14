package com.ccniit.graduation.service;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.qo.AuthorBaseUpdater;
import com.ccniit.graduation.pojo.qo.AuthorInfoUpdater;

public interface AuthorService {

	public static final int UPDATE_SUCCESS = 1;
	public static final int PASSWORD_ERROR = -1;
	public static final int PASSWORD_NOT_SAME = -2;

	/**
	 * author注册,添加一条空的AuthorInfo //TODO add comments
	 * 
	 * @param author
	 * @return author.id
	 */
	Long insertAuthor(Author author) throws IException;

	/**
	 * 更新Author的基本信息
	 * 
	 * @param AuthorUpdater
	 * @return Integer，返回值对应的意义如下： 1 = 修改成功;-1=密码错误；-2=新密码和确认密码不一致；
	 * @throws IException
	 */
	Integer updateAuthorBase(AuthorBaseUpdater authorUpdater) throws IException;

	/**
	 * 更新Author的扩展信息
	 * 
	 * @param AuthorUpdater(Author更新器)
	 * @return affected rows(1 OR 0 success)
	 * 
	 */
	Integer updateAuthorInfo(AuthorInfoUpdater authorUpdater) throws IException;

	/**
	 * 
	 * */
	Long getAuthorIdByEmail(String email) throws IException;

	/**
	 * 判断邮箱是否注册过
	 * 
	 * @param 邮箱
	 * @return 是否注册过
	 */
	Boolean authorIsExist(String email) throws IException;

	/**
	 * 获取Author，忽略密码，使用缓存
	 * 
	 * @param Author.id
	 * @return Author(ignore password and secondPassword)
	 */
	Author findAuthorById(long id) throws IException;

}
