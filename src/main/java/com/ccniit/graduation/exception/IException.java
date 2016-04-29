package com.ccniit.graduation.exception;

public class IException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5108882443681231991L;

	protected int code;

	public IException(String message) {
		super(message);
	}

	public int getCode() {
		return code;
	}

}
