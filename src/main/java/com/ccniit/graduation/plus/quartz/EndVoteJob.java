package com.ccniit.graduation.plus.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.LoggerUtils;

@Component("endVoteJob")
public class EndVoteJob implements Job {

	private static final Logger DEV = LoggerUtils.getDev();

	@Override
	public void execute(JobExecutionContext executionContext) throws JobExecutionException {
		try {
			JobDataMap dataMap = executionContext.getJobDetail().getJobDataMap();
			VoteService voteService = (VoteService) dataMap.get("VOTE_SERVICE");
			Long voteId = dataMap.getLong("VOTE_ID");
			if (null == voteService) {
				DEV.debug(" Error,voteService is a null");
			}
			voteService.updateVoteToEnd(voteId);
		} catch (Exception e) {
			DEV.error(e.getCause().getMessage(), e);
		}
	}

}
