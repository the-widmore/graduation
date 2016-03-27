package com.ccniit.graduation.plus.emil;

import javax.mail.Authenticator;

import org.apache.commons.mail.DefaultAuthenticator;

public class EmailProvider163 extends EmailServerProvider {

	private static final String HOST_NAME = "smtp.163.com";
	private static final int SMTP_PORT = 465;
	private static final String USER_NAME = "chenyiyuan00";
	private static final String PASSWORD = "Zhijun944586";
	private static final String FROM = "chenyiyuan00@163.com";

	public EmailProvider163(String hostName, int smtpPort, Authenticator authenticator, String from) {
		super(hostName, smtpPort, authenticator, from);
	}

	public EmailProvider163() {
		super(HOST_NAME, SMTP_PORT, new DefaultAuthenticator(USER_NAME, PASSWORD), FROM);
	}

	@Override
	public String getName() {
		return "EastVote";
	}

}
