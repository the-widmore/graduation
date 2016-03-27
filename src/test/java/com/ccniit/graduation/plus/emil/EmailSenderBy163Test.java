package com.ccniit.graduation.plus.emil;

import javax.annotation.Resource;

import org.apache.commons.mail.EmailException;
import org.junit.Test;

import com.ccniit.graduation.BaseTest;

public class EmailSenderBy163Test extends BaseTest {

	protected static final String TEST_TO = "1174310485@qq.com";

	@Resource
	EmailService emailService163;

	@Test
	public void testSendMsg() throws EmailException {
		emailService163.sendMsg(TEST_TO, "邮件测试", "Hello World!");
	}

}
