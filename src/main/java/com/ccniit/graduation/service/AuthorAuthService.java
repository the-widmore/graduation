package com.ccniit.graduation.service;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.vo.EmailToken;
import com.ccniit.graduation.pojo.vo.PhoneToken;

/**
 * Author的认证服务
 * 
 */
public interface AuthorAuthService {

	/**
	 * @param 邮箱和密码
	 * @throws IException
	 * @return 是否正确
	 */
	boolean verifyByEmail(EmailToken token) throws IException;

	/**
	 * @param 电话和密码
	 * @throws IException
	 * @return 是否正确
	 */
	boolean verifyByPhone(PhoneToken token) throws IException;

}
