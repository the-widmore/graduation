package com.ccniit.graduation.exception;

public class VoteNotExistException extends ServerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int VOTE_NOT_FOUND_EXCEPTION_CODE = 502;

	public VoteNotExistException(String message) {
		super(message);
	}

}
