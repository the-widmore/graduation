package com.ccniit.graduation.service;

import java.util.List;
import java.util.Map;

import com.ccniit.graduation.exception.IException;

public interface VoteDateService {

	/**
	 * 统计收集到的数据
	 * 
	 * @throws IException
	 */
	List<Map<String, Integer>> statisticsVoteData(Long vote) throws IException;

}
