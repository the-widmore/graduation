package com.ccniit.graduation.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccniit.graduation.dao.mongodb.IVoteDataDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.service.VoteDataService;
import com.ccniit.graduation.service.VoteService;

@RestController
public class DataController {

	// TODO 身份验证

	@Resource
	private VoteService voteService;
	@Resource
	IVoteDataDao voteDataDao;
	@Resource
	private VoteDataService voteDataService;

	private static final String CHART_DATA_URL = "/data/chart/{vid}/{qid}";

	@RequestMapping(value = CHART_DATA_URL, method = { RequestMethod.GET, RequestMethod.POST })
	public List<List<Object>> getVoteChartData(@PathVariable("vid") long vid, @PathVariable("qid") int qid)
			throws IException {
		// FIXME remove
		vid = 47L;

		return voteDataService.toC3Pie(vid, qid).getColumns();
	}

}
