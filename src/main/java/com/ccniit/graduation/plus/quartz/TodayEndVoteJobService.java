package com.ccniit.graduation.plus.quartz;

import static com.ccniit.graduation.plus.quartz.QuartzResource.VOTE_END_JOB_GROUP;
import static com.ccniit.graduation.plus.quartz.QuartzResource.VOTE_END_JOB_PREFIX;

import java.util.List;

import javax.annotation.Resource;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.DateUtils;
import com.ccniit.graduation.util.LoggerUtils;

/**
 * 今天结束的Vote任务
 */
@Service("todayEndVoteJobService")
public class TodayEndVoteJobService {

	private static final Logger DEV = LoggerUtils.getDev();

	@Resource
	VoteService voteService;
	@Resource
	SchedulerFactory schedulerFactory;

	// 每天执行一次
	/** @Scheduled(cron = "0 0 0 1/1 * ? ") */
	@Scheduled(cron = "0 0/1 * * * ? ") // 每分钟执行一次
	public void getTodayEndVoteJob() throws IException, SchedulerException {
		List<Long> todayWillEndVoteIds = voteService.selectTodayWillEndVote();

		for (Long todayWillEndVoteId : todayWillEndVoteIds) {
			addJob(todayWillEndVoteId);
		}
	}

	public void addJob(Long jobId) throws SchedulerException, IException {
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		JobBuilder jobBuilder = JobBuilder.newJob(EndVoteJob.class);
		jobBuilder.withIdentity(VOTE_END_JOB_PREFIX + jobId, VOTE_END_JOB_GROUP);
		JobDetail jobDetail = jobBuilder.build();

		Vote vote = voteService.selectVote(jobId);

		JobDataMap dataMap = jobDetail.getJobDataMap();
		dataMap.put("VOTE_ID", jobId);
		dataMap.put("VOTE_SERVICE", voteService);

		Trigger trigger = TriggerBuilder.newTrigger().startAt(vote.getPredictDate()).build();
		scheduler.scheduleJob(jobDetail, trigger);

		DEV.debug("job {} will be trigger in {}", jobDetail.getDescription(), DateUtils.y4M2d2h2m2(null));
	}

}
