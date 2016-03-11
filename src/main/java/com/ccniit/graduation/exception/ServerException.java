package com.ccniit.graduation.exception;

public class ServerException extends IException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7493785619983640049L;
	private static final String EXCEPTION_TYPE = "Server>";

	public ServerException(String message) {
		super(EXCEPTION_TYPE.concat(message));
	}

}
