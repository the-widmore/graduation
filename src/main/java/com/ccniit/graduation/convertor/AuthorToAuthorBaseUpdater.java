package com.ccniit.graduation.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.qo.AuthorBaseUpdater;

@Component("authorToAuthorBaseUpdater")
public class AuthorToAuthorBaseUpdater implements Converter<Author, AuthorBaseUpdater> {

	AuthorBaseUpdater baseUpdater = null;

	@Override
	public AuthorBaseUpdater convert(Author author) {
		baseUpdater = new AuthorBaseUpdater();
		baseUpdater.setEmail(author.getEmail());
		baseUpdater.setName(author.getName());
		baseUpdater.setNickName(author.getNickName());
		baseUpdater.setSex(author.getSex());
		baseUpdater.setPhone(author.getPhone());
		return baseUpdater;
	}

}
