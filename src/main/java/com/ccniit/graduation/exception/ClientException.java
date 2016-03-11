package com.ccniit.graduation.exception;

public class ClientException extends IException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -56152791498876537L;

	private static final String EXCEPTION_TYPE = "Client>";

	public ClientException(String message) {
		super(EXCEPTION_TYPE + message);
	}

}
