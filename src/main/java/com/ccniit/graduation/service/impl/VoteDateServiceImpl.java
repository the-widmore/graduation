package com.ccniit.graduation.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mongodb.IVoteDataDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.plus.chart.VoteQuestionAnswerCounter;
import com.ccniit.graduation.pojo.doc.BaseVoteData;
import com.ccniit.graduation.service.VoteDateService;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.CollectionUtils;
import com.ccniit.graduation.util.LoggerUtils;

@Service("voteDateService")
public class VoteDateServiceImpl implements VoteDateService {

	private static Logger DEV = LoggerUtils.getDev();
	private static Logger ERR = LoggerUtils.getErr();

	@Resource
	VoteService voteService;
	@Resource
	IVoteDataDao voteDataDao;

	@Override
	public List<Map<String, Integer>> statisticsVoteData(Long vote) throws IException {
		String collectionName = voteService.selectVote(vote).getTableName();
		List<BaseVoteData> voteDatas = voteDataDao.selectVote(collectionName);

		List<Map<String, Integer>> questionsCounter = new ArrayList<>();

		List<VoteQuestionAnswerCounter> questionAnswerCounters = new ArrayList<>();

		for (BaseVoteData baseVoteData : voteDatas) {
			Map<String, String[]> questionDataMap = baseVoteData.getData();
			int question = questionDataMap.size();
			for (int i = 1; i <= question; i++) {
				String questionKey = "q" + i;
				if (questionDataMap.containsKey(questionKey)) {
					VoteQuestionAnswerCounter voteQuestionAnswerCounter = new VoteQuestionAnswerCounter();
					String[] answers = questionDataMap.get("q" + i);

					CollectionUtils.frequency(Arrays.asList(answers));

					DEV.debug("{}:{}", "q" + i, answers);

				} else {
					continue;
				}

			}
			// TODO
			Map<String, Integer> questionMap = new HashMap<>();

		}
		return null;
	}

}
