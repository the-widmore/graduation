package com.ccniit.graduation.plus.chart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccniit.graduation.dao.mongodb.IVoteDataDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.doc.BaseVoteData;
import com.ccniit.graduation.service.VoteService;

@RestController
public class DataController {

	// TODO 身份验证

	@Resource
	VoteService voteService;
	@Resource
	IVoteDataDao voteDataDao;

	private static final String CHART_DATA_URL = "/data/chart/{vote}";

	@RequestMapping(value = CHART_DATA_URL, method = { RequestMethod.GET, RequestMethod.POST })
	public String getVoteChartData(@PathVariable("vote") Long vote) throws IException {
		// FIXME remove
		vote = 47L;

		String collectionName = voteService.selectVote(vote).getTableName();
		List<BaseVoteData> voteDatas = voteDataDao.selectVote(collectionName);

		List<Map<String, Integer>> questionsCounter = new ArrayList<>();
		for (BaseVoteData baseVoteData : voteDatas) {

		}

		return null;
	}

}
