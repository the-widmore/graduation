package com.ccniit.graduation.plus.emil;

import java.util.List;

import org.apache.commons.mail.EmailException;

public interface SimpleEmailSender {

	void build(EmailServerProvider provider) throws EmailException;

	/**
	 * 在调用send方法前必须先调用build方法
	 * 
	 * @throws EmailException
	 */
	void send(EmailTemplate template) throws EmailException;

	void sendAll(EmailTemplate template, List<String> tos) throws EmailException;

}
