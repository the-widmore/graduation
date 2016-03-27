package com.ccniit.graduation.plus.emil;

import org.apache.commons.mail.EmailException;

public interface EmailService {

	void sendMsg(String to, String subject, String msg) throws EmailException;

}
