package com.ccniit.graduation.exception;

public class ParamsException extends ClientException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8932533263895002764L;

	public ParamsException(String message) {
		super("参数错误" + message);
	}

}
