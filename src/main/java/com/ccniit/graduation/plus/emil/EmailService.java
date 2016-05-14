package com.ccniit.graduation.plus.emil;

import org.apache.commons.mail.EmailException;

public interface EmailService {

	/**
	 * 向单个邮箱发送邮件
	 * 
	 * @throws EmailException
	 */
	void sendMessage(EmailTemplate template) throws EmailException;

	/**
	 * 向多个邮箱发送相同的邮件
	 * 
	 * @throws EmailException
	 */
	void sendMessages(EmailTemplate template) throws EmailException;

}
