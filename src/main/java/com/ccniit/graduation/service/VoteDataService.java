package com.ccniit.graduation.service;

import java.util.Map;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.plus.chart.ChartData4C3Pie;

public interface VoteDataService {

	/**
	 * 问题编号前缀 'q'
	 */
	public static final String QUESTION_PREFIX = "q";

	/**
	 * 统计收集到的数据 Map<questionId,Map<选项,选项的次数>>
	 * 
	 * @param 要统计的Vote的id
	 * @throws IException
	 */
	Map<String, Map<String, Integer>> statisticsVoteData(Long vote) throws IException;

	/**
	 * 获取一个问题的选项
	 * 
	 * @param vote
	 *            Vote的id
	 * @param question
	 *            问题编号
	 **/
	Map<String, Integer> getQuestionCountMap(long vote, int question) throws IException;

	/**
	 * 获取适配于 ChartData4C3Pie 的一个问题的数据
	 * 
	 * @throws IException
	 */
	ChartData4C3Pie toC3Pie(long vote, int question) throws IException;

}
