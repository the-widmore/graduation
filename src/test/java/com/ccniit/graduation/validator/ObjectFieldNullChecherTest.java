package com.ccniit.graduation.validator;

import static org.junit.Assert.assertEquals;

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
	public void testCheck() {
		Address address = new Address("priv", "city", null);
		User user = new User("Carbon", address);
		try {
			boolean addressIsNull = objectFieldNullChecher.check(user, "address");
			boolean streetIsNull = objectFieldNullChecher.check(user, "address.street");
			assertEquals(false, addressIsNull);
			assertEquals(true, streetIsNull);
		} catch (IException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
