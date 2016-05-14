package com.ccniit.graduation.convertor;

import javax.annotation.Resource;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.vo.UserRegister;
import com.ccniit.graduation.service.AuthorAuthService;

@Component("userRegisterToAuthor")
public class UserRegisterToAuthor implements Converter<UserRegister, Author> {

	@Resource
	private AuthorAuthService authorAuthService;

	@Override
	public Author convert(UserRegister userRegister) {
		Author author = new Author();
		author.setEmail(userRegister.getEmail());
		// 密码散列
		author.setPassword(authorAuthService.encodePassword(userRegister.getPassword()));
		author.setNickname(userRegister.getNickname());

		return author;
	}

}
