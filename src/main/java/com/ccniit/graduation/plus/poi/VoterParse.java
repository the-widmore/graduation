package com.ccniit.graduation.plus.poi;

import java.util.List;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Voter;

public interface VoterParse {

	/**
	 * Voter解析接口，如果是Excel参数是文件路径。如果从文本解析，参数为内容和默认邮箱服务
	 * 
	 * @param String[]
	 * @return List<Voter>
	 */
	List<Voter> parse(String[] params) throws IException;

}
