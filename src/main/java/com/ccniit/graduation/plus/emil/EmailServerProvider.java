package com.ccniit.graduation.plus.emil;

import javax.mail.Authenticator;

/**
 * 邮件服务提供者
 */
public class EmailServerProvider {

	protected String hostName;
	protected int smtpPort;
	protected Authenticator authenticator;
	//
	protected String from;
	protected String name;

	public EmailServerProvider() {
		super();
	}

	public EmailServerProvider(String hostName, int smtpPort, Authenticator authenticator, String from) {
		super();
		this.hostName = hostName;
		this.smtpPort = smtpPort;
		this.authenticator = authenticator;
		this.from = from;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(int smtpPort) {
		this.smtpPort = smtpPort;
	}

	public Authenticator getAuthenticator() {
		return authenticator;
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
