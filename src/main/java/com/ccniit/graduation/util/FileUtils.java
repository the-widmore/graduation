package com.ccniit.graduation.util;

import java.io.File;

/**
 * 文件处理工具类
 */
public class FileUtils {

	private static final String POINT = ".";

	/**
	 * 获取文件后缀
	 * 
	 * @param fileName
	 *            文件名，或者文件路径
	 * @return 文件后缀
	 */
	public static String getFileSuffix(String fileName) {
		if (fileName.contains(POINT)) {
			return fileName.substring(fileName.lastIndexOf(POINT));
		} else {
			return fileName;
		}
	}

	/**
	 * 获取文件后缀
	 * 
	 * @param file
	 *            文件对象
	 * @return 文件后缀。如果是文件夹。返回 null
	 */
	public static String getFileSuffix(File file) {
		if (file.isDirectory()) {
			return null;
		} else {
			return getFileSuffix(file.getName());
		}
	}

}
