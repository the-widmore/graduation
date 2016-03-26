package com.ccniit.graduation.service;

import com.ccniit.graduation.pojo.common.UserToken;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.qo.AuthorUpdater;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;

public interface AuthorService {

	/**
	 * author注册,添加一条空的AuthorInfo //TODO add comments
	 * 
	 * @param author
	 * @return author.id
	 */
	long register(Author author);

	boolean authentication(UserToken userToken);

	/**
	 * 更新Author的基本信息
	 * 
	 * @param AuthorUpdater
	 * @return updated
	 */
	int updateAuthorBase(AuthorUpdater authorUpdater);

	int updateAuthorInfo(AuthorUpdater authorUpdater);

	long getAuthorIdByEmail(String email);

	boolean authorIsExist(String email);

	Author findAuthorById(long id);

	AuthorContentCounter getAuthorContentCounter(long authorId);

}
