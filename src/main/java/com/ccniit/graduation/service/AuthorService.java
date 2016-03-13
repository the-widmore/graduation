package com.ccniit.graduation.service;

import com.ccniit.graduation.pojo.db.Author;

public interface AuthorService {

	/**
	 * author注册,添加一条空的AuthorInfo //TODO
	 * 
	 * @param author
	 * @return author.id
	 */
	long register(Author author);

}
