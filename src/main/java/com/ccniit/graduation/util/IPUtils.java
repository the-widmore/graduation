package com.ccniit.graduation.util;

public class IPUtils {

	public static long ipToLong(String ipaddress) {
		String[] ipPartsStr = StringUtils.split(ipaddress, "\\.");
		int[] ip = new int[4];
		for (int i = 0; i < 4; i++) {
			ip[i] = Integer.parseInt(ipPartsStr[i]);
		}
		return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
	}

	public static String longToIP(long ipaddress) {
		StringBuffer ipAddressBuild = new StringBuffer();
		ipAddressBuild.append(String.valueOf((ipaddress >>> 24)));
		ipAddressBuild.append(".");
		ipAddressBuild.append(String.valueOf((ipaddress & 0x00FFFFFF) >>> 16));
		ipAddressBuild.append(".");
		ipAddressBuild.append(String.valueOf((ipaddress & 0x0000FFFF) >>> 8));
		ipAddressBuild.append(".");
		ipAddressBuild.append(String.valueOf((ipaddress & 0x000000FF)));
		return ipAddressBuild.toString();
	}

}
