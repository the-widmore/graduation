package com.ccniit.graduation.dao.mysql;

import com.ccniit.graduation.exception.IException;

public class AuthorNotFoundException extends IException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9149302952075811632L;

	public AuthorNotFoundException(String message) {
		super(message);
	}

}
