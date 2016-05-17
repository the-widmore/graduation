package com.ccniit.graduation.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.dao.mongodb.IVoteDataDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.plus.chart.ChartData4C3Pie;
import com.ccniit.graduation.pojo.doc.BaseVoteData;
import com.ccniit.graduation.service.VoteDataService;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.util.CollectionUtils;
import com.ccniit.graduation.util.JSONUtils;
import com.ccniit.graduation.util.LoggerUtils;

@Service("voteDataService")
public class VoteDateServiceImpl implements VoteDataService {

	private static Logger DEV = LoggerUtils.getDev();

	@Resource
	VoteService voteService;
	@Resource
	IVoteDataDao voteDataDao;

	@Override
	public Map<String, Map<String, Integer>> statisticsVoteData(Long vote) throws IException {
		String collectionName = voteService.selectVote(vote).getTableName();
		List<BaseVoteData> voteDatas = voteDataDao.selectVote(collectionName);

		Map<String, Map<String, Integer>> voetCounterMap = new HashMap<>();

		for (BaseVoteData baseVoteData : voteDatas) {

			Map<String, String[]> questionDataMap = baseVoteData.getData();
			int question = questionDataMap.size();

			DEV.debug("vid:{} ", baseVoteData.getData().get("vid"));

			for (int i = 1; i < question; i++) {
				String questionKey = QUESTION_PREFIX + i;
				String[] answers = questionDataMap.get(questionKey);

				if (null == answers || 0 == answers.length) {
					DEV.debug("someone not answer the qid is {} question", questionKey);
					continue;
				}

				DEV.debug("{}:{}", questionKey, answers);

				Map<String, Integer> questionCountMap = null;
				if (voetCounterMap.containsKey(questionKey)) {
					questionCountMap = voetCounterMap.get(questionKey);
					voetCounterMap.put(questionKey, CollectionUtils.frequency(answers, questionCountMap));
				} else {
					questionCountMap = CollectionUtils.frequency(answers);
					voetCounterMap.put(questionKey, questionCountMap);
				}

				DEV.debug("questionCountMap:{}", questionCountMap);
			}
		}

		DEV.debug("voetCounterMap:{}", voetCounterMap);

		return voetCounterMap;
	}

	@Override
	public Map<String, Integer> getQuestionCountMap(long vote, int question) throws IException {

		Map<String, Integer> questionCountMap = statisticsVoteData(vote).get(QUESTION_PREFIX + question);

		return questionCountMap;
	}

	@Override
	public ChartData4C3Pie toC3Pie(long vote, int question) throws IException {

		Map<String, Integer> questionCountMap = getQuestionCountMap(vote, question);
		ChartData4C3Pie chartData4C3Pie = new ChartData4C3Pie();
		List<List<Object>> columns = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : questionCountMap.entrySet()) {
			List<Object> dataArray = new ArrayList<>(2);
			dataArray.add(0, entry.getKey());
			dataArray.add(1, entry.getValue());
			columns.add(dataArray);
		}
		// TODO FIXME
		DEV.debug("chartData4C3Pie {}", JSONUtils.toJSON(chartData4C3Pie));

		return chartData4C3Pie;
	}

}
