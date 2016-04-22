package com.ccniit.graduation.plus.emil;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.resource.Commons;

@Service("simpleEmailSender")
public class SimpleEmailSenderImpl implements SimpleEmailSender {

	private Email email;

	@Override
	public void build(EmailServerProvider provider) throws EmailException {
		Email email = new SimpleEmail();
		email.setCharset(Commons.SYSTEM_CHARSET);
		email.setHostName(provider.getHostName());
		email.setSmtpPort(provider.getSmtpPort());
		email.setAuthenticator(provider.getAuthenticator());
		email.setSSLOnConnect(true);
		email.setFrom(provider.getFrom());
		this.email = email;
	}

	@Override
	public void send(EmailTemplate template) throws EmailException {
		email.addTo(template.getTo());
		email.setSubject(template.getSubject());
		email.setMsg(template.getContent());
		email.send();
	}

	@Override
	public void sendAll(EmailTemplate template, List<String> tos) throws EmailException {
		String mainEmail = template.getTo();

		if (StringUtils.isNotBlank(mainEmail)) {
			email.addTo(mainEmail);
		}
		for (String emailAddress : tos) {
			email.addTo(emailAddress);
		}

		email.setSubject(template.getSubject());
		email.setMsg(template.getContent());
		email.send();
	}

}
