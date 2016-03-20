package com.ccniit.graduation.plus.poi;

import java.util.Hashtable;
import java.util.Map;

public class ParseQueueImpl implements ParseQueue {

	// use Hashtable(Thread safe)
	private static Map<String, Integer> queue = new Hashtable<>();
	private static boolean parsing;

	@Override
	public boolean add(String excelPath, int primary) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void start() {

	}

}
