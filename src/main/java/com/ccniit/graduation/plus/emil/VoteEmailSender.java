package com.ccniit.graduation.plus.emil;

import javax.annotation.Resource;

public class VoteEmailSender {

	@Resource
	EmailProvider163 emailProvider163;
	@Resource
	SimpleEmailSender simpleEmailSender;

	public void sendEmailToVoteVoters(Long vote) {
		
	}

}
