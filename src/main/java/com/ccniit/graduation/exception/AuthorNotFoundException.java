package com.ccniit.graduation.exception;

public class AuthorNotFoundException extends ServerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9149302952075811632L;

	public static final int AUTHOR_NOT_FOUND_EXCEPTION_CODE = 501;

	public AuthorNotFoundException(String message) {
		super(message);
		code = AUTHOR_NOT_FOUND_EXCEPTION_CODE;
	}

}
