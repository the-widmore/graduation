package com.ccniit.graduation.service.impl;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;
import com.ccniit.graduation.service.AuthorService;

public class AuthorServiceImplTest extends BaseTest {

	@Resource
	AuthorService authorService;

	@Test
	public void testRegister() {
		fail("Not yet implemented");
	}

	@Test
	public void testAuthentication() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBaseInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAuthorIdByEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShowName() {
		fail("Not yet implemented");
	}

	@Test
	public void testAuthorIsExist() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAuthorById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAuthorAuthorContentCounter() {
		AuthorContentCounter authorContentCounter1 = authorService.getAuthorAuthorContentCounter(1);
		AuthorContentCounter authorContentCounter2 = authorService.getAuthorAuthorContentCounter(1);
		AuthorContentCounter authorContentCounter3 = authorService.getAuthorAuthorContentCounter(1);
		System.out.println(authorContentCounter1);
		System.out.println(authorContentCounter2);
		System.out.println(authorContentCounter3);
	}

}
