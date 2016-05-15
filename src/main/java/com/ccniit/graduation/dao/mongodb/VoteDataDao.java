package com.ccniit.graduation.dao.mongodb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.ccniit.graduation.pojo.doc.BaseVoteData;
import com.ccniit.graduation.util.JSONUtils;
import com.ccniit.graduation.util.LoggerUtils;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

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
		mongoTemplate.dropCollection(tableName);
	}

	@Override
	public List<BaseVoteData> selectVote(String tableName) {
		DBCollection collection = mongoTemplate.getCollection(tableName);
		DBCursor cursor = collection.find();
		List<BaseVoteData> voteDates = new ArrayList<>(cursor.count());

		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			BaseVoteData voteData = JSONObject.parseObject(JSON.serialize(dbObject), BaseVoteData.class);
			voteDates.add(voteData);
		}

		return voteDates;
	}

	@Override
	public Long counterVoteSubmitTimes(String tableName) {
		return mongoTemplate.getCollection(tableName).count();
	}

}
