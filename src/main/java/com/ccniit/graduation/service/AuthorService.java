package com.ccniit.graduation.service;

import com.ccniit.graduation.pojo.common.UserBaseInfo;
import com.ccniit.graduation.pojo.common.UserToken;
import com.ccniit.graduation.pojo.db.Author;

public interface AuthorService {

	/**
	 * author注册,添加一条空的AuthorInfo //TODO
	 * 
	 * @param author
	 * @return author.id
	 */
	long register(Author author);

	boolean authentication(UserToken userToken);

	void updateBaseInfo(UserBaseInfo userBaseInfo);

	long getAuthorIdByEmail(String email);

	Object getShowName(Long id);

	boolean authorIsExist(Object email);

	Author findAuthorById(long id);

}
