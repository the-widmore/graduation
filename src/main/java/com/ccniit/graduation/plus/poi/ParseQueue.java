package com.ccniit.graduation.plus.poi;

/**
 * excel解析比较消耗资源，使用队列保证服务器稳定
 */
public interface ParseQueue {

	boolean add(String excelPath, int primary);

	void start();

}
