package com.ccniit.graduation.exception;

import org.junit.Test;

public class DaoExceptionTest {

	@Test
	public void testDaoException() {
		DaoException daoException = new DaoException("SQL 语法错误");

		String message = daoException.getMessage();

		System.out.println(message);
	}

}
