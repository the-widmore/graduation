package com.ccniit.graduation.dao.mongodb;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ccniit.graduation.pojo.doc.BaseVoteData;
import com.ccniit.graduation.util.LoggerUtils;

@Repository("voteDataDao")
public class VoteDataDao implements IVoteDataDao {

	private static final Logger DEV = LoggerUtils.getDev();

	@Resource
	MongoTemplate mongoTemplate;

	@Override
	public void insertVoteData(String tableName, BaseVoteData dataDoc) {
		mongoTemplate.insert(dataDoc, tableName);
	}

	@Override
	public void dropVoteData(String tableName) {

		DEV.debug("collection {} be droped.", tableName);

		mongoTemplate.dropCollection(tableName);
	}

	@Override
	public List<BaseVoteData> selectVote(String tableName) {

		return mongoTemplate.findAll(BaseVoteData.class, tableName);
	}

	@Override
	public Long counterVoteSubmitTimes(String tableName) {
		return mongoTemplate.getCollection(tableName).count();
	}

}
