package com.ccniit.graduation.dao.mongodb;

import java.util.List;

import com.ccniit.graduation.pojo.doc.BaseVoteData;

public interface IVoteDataDao {

	void insertVoteData(String tableName, BaseVoteData dataDoc);

	void dropVoteData(String tableName);

	List<BaseVoteData> selectVote(String tableName);

}
