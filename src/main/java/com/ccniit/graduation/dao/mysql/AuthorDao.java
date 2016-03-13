package com.ccniit.graduation.dao.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.mapper.AuthorMapper;
import com.ccniit.graduation.pojo.db.Author;

@Repository("authorDao")
public class AuthorDao implements AuthorMapper {

	@Resource
	AuthorMapper authorMapper;

	@Override
	public long insertAuthor(Author author) {
		return authorMapper.insertAuthor(author);
	}

	@Override
	public Author selectById(long id) {
		return authorMapper.selectById(id);
	}

	@Override
	public long selectAuthorIdByEmail(String email) {
		return authorMapper.selectAuthorIdByEmail(email);
	}

	@Override
	public Author selectByEmail(String email) {
		return authorMapper.selectByEmail(email);
	}

	@Override
	public int updateAuthor(Author author) {
		return authorMapper.updateAuthor(author);
	}

	@Override
	public int countByEmail(String email) {
		return authorMapper.countByEmail(email);
	}

}
