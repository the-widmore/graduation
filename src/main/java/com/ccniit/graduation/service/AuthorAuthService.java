package com.ccniit.graduation.service;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.vo.EmailToken;
import com.ccniit.graduation.pojo.vo.PhoneToken;

/**
 * Author的认证服务
 * 
 */
public interface AuthorAuthService {

	public static enum AccountStatus {
		/** 刚刚注册 */
		registered,
		/** 正常状态 */
		activated,
		/** 锁定状态 */
		locked
	}

	/**
	 * 对密码进行编码，使用hex(sha1(password))
	 * 
	 * @param password
	 *            明文密码
	 * @return 加密的密码
	 */
	public String encodePassword(String password);

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
