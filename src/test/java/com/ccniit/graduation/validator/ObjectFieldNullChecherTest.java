package com.ccniit.graduation.validator;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.Address;
import com.ccniit.graduation.pojo.User;

public class ObjectFieldNullChecherTest extends BaseTest {

	@Resource
	ObjectFieldNullChecher objectFieldNullChecher;

	@Test
	public void testCheck() throws IException {
		Address address = new Address("priv", "city", null);
		User user = new User("Carbon", address);
		boolean addressIsNull = objectFieldNullChecher.check(user, "address");
		assertEquals(false, addressIsNull);
		boolean streetIsNull = objectFieldNullChecher.check(user, "address.street");
		assertEquals(true, streetIsNull);
	}

}
