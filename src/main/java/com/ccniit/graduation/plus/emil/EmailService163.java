package com.ccniit.graduation.plus.emil;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.util.LoggerUtils;

@Service("emailService163")
public class EmailService163 implements EmailService {

	private static final Logger LOG = LoggerUtils.getErr();

	@Override
	public void sendMsg(String to, String subject, String msg) {
		EmailServerProvider provider = new EmailProvider163();
		Email email = new SimpleEmail();
		email.setSSLOnConnect(true);// use SSL connection
		email.setHostName(provider.getHostName());
		email.setSmtpPort(provider.smtpPort);
		email.setAuthenticator(provider.getAuthenticator());
		email.setSubject(subject);
		try {
			email.setFrom(provider.getFrom(), provider.getName());
			email.addTo(to);
			email.setMsg(msg);
			email.send();
		} catch (EmailException e) {
			LOG.error(e.getMessage(), e);
		}
	}

}
