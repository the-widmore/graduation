package com.ccniit.graduation.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.qo.AuthorBaseUpdater;

@Component("authorBaseUpdaterToAuthor")
public class AuthorBaseUpdaterToAuthor implements Converter<AuthorBaseUpdater, Author> {

	private Author author = null;

	@Override
	public Author convert(AuthorBaseUpdater source) {
		author = new Author();
		author.setId(source.getId());
		author.setName(source.getName());
		author.setNickName(source.getNickName());
		author.setPhone(source.getPhone());
		author.setSex(source.getSex());

		//
		author.setPassword(source.getConfirmPassword());
		author.setSecondPassword(source.getSecondPassword());

		return author;
	}

}
