package com.ccniit.graduation.util;

import org.junit.Test;

public class IPUtilsTest {

	private static String TEST_HOST = "127.0.0.1";

	@Test
	public void testIpToLong() {
		long ipLong = IPUtils.ipToLong(TEST_HOST);
		System.out.println(ipLong);
	}

	@Test
	public void testLongToIP() {
		long ipLong = 2130706433;
		System.out.println(IPUtils.longToIP(ipLong));
	}

}
