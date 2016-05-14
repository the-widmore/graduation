package com.ccniit.graduation.dao.mysql;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ccniit.graduation.exception.AuthorNotFoundException;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.mapper.AuthorMapper;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.vo.EmailToken;

@Repository("authorDao")
public class AuthorDao implements AuthorMapper {

	@Resource
	AuthorMapper authorMapper;

	@Override
	public Long insertAuthor(Author author) {
		authorMapper.insertAuthor(author);
		return author.getId();
	}

	@Override
	public Author selectById(long id) {
		return authorMapper.selectById(id);
	}

	@Override
	public Long selectAuthorIdByEmail(String email) {
		return authorMapper.selectAuthorIdByEmail(email);
	}

	@Override
	public Author selectAuthorByEmail(String email) {
		return authorMapper.selectAuthorByEmail(email);
	}

	@Override
	public Integer updateAuthorPassword(Author author) {
		return authorMapper.updateAuthorPassword(author);
	}

	@Override
	public Integer updateAuthorSecondPassword(Author author) {
		return authorMapper.updateAuthorSecondPassword(author);
	}

	@Override
	public Integer updateAuthorWithoutPassword(Author author) {
		return authorMapper.updateAuthorWithoutPassword(author);
	}

	@Override
	public Integer countByEmail(String email) {
		return authorMapper.countByEmail(email);
	}

	@Override
	public EmailToken selectAuthorEmailToken(String email) throws IException {
		EmailToken token = authorMapper.selectAuthorEmailToken(email);

		// 没有查询到该Author
		if (null == token) {
			throw new AuthorNotFoundException("not found this author");
		}

		return token;
	}

}
