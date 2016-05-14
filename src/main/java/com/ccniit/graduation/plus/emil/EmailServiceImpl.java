package com.ccniit.graduation.plus.emil;

import javax.annotation.Resource;

import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Resource
	SimpleEmailSender simpleEmailSender;
	@Resource
	EmailServerProvider emailProvider163;

	@Override
	public void sendMessage(EmailTemplate template) throws EmailException {
		simpleEmailSender.build(emailProvider163);
		simpleEmailSender.send(template);
	}

	@Override
	public void sendMessages(EmailTemplate template) throws EmailException {
		simpleEmailSender.build(emailProvider163);
		simpleEmailSender.sendAll(template);
	}

}
