package com.ccniit.graduation.exception;

public class DaoException extends ServerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7337865007175518461L;
	private static final String EXCEPTION_TYPE = "Dao>";

	public DaoException(String message) {
		super(EXCEPTION_TYPE.concat(message));
	}

}
