package com.ccniit.graduation.validator;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.resource.SpringScope;
import com.ccniit.graduation.util.FileUtils;

/**
 * Vote由上传文件创建，文件类型检查
 */
@Component("voteCreateFormFileChecker")
@Scope(SpringScope.SINGLETON)
public class VoteCreateFormFileChecker implements StringVaildator {

	/**
	 * 允许上传的类型
	 */
	private static final String[] ACCESS_FILE_TYPE = { ".xls", ".xlsx", ".doc", ".docx", ".pdf", ".png", ".jpg" };

	private static final Set<String> ACCESS_FILE_TYPE_SET = new HashSet<>();
	static {
		for (int i = 0; i < ACCESS_FILE_TYPE.length; i++) {
			ACCESS_FILE_TYPE_SET.add(ACCESS_FILE_TYPE[i]);
		}
	}

	@Override
	public boolean chech(String source) throws IException {
		String fileSuffix = FileUtils.getFileSuffix(source).toLowerCase();
		if (ACCESS_FILE_TYPE_SET.contains(fileSuffix)) {
			return true;
		}

		return false;
	}

}
