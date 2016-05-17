package com.ccniit.graduation.plus.chart;

import java.io.Serializable;
import java.util.Map;

/**
 * Vote的统计结果
 */
public class VoteDataStatisticsResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5921036211443905042L;
	private long vote;
	private Map<String, Map<String, Integer>> result;

	public VoteDataStatisticsResult() {
		super();
	}

	public VoteDataStatisticsResult(long vote, Map<String, Map<String, Integer>> result) {
		super();
		this.vote = vote;
		this.result = result;
	}

	public long getVote() {
		return vote;
	}

	public void setVote(long vote) {
		this.vote = vote;
	}

	public Map<String, Map<String, Integer>> getResult() {
		return result;
	}

	public void setResult(Map<String, Map<String, Integer>> result) {
		this.result = result;
	}

}
