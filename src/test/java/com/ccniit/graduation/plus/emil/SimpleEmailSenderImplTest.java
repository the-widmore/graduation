package com.ccniit.graduation.plus.emil;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.mail.EmailException;
import org.junit.Test;

import com.ccniit.graduation.BaseTest;

public class SimpleEmailSenderImplTest extends BaseTest {

	@Resource
	SimpleEmailSender simpleEmailSender;
	@Resource
	EmailServerProvider emailProvider163;

	@Test
	public void testSend() throws EmailException {
		simpleEmailSender.build(emailProvider163);
		EmailTemplate template = new EmailTemplate("测试邮件", "邮件内容");
		simpleEmailSender.send(template);

	}

	@Test
	public void testSendAll() throws EmailException {
		simpleEmailSender.build(emailProvider163);
		// EmailTemplate template = new EmailTemplate("测试邮件", "邮件内容")
		// simpleEmailSender.send(template);
		List<String> receivers = new ArrayList<>();
		receivers.add("18681714595@163.com");
		receivers.add("qq1174310485@163.com");
		receivers.add("7rnkdr3osg155v@my10minutemail.com");
		simpleEmailSender.sendAll(new EmailTemplate("测试邮件", "邮件内容", "1174310485@qq.com"), receivers);
	}

}
