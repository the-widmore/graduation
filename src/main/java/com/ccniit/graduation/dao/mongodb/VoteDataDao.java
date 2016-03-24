package com.ccniit.graduation.dao.mongodb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ccniit.graduation.pojo.doc.BaseVoteData;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Repository("voteDataDao")
public class VoteDataDao implements IVoteDataDao {

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
		List<DBObject> list = cursor.toArray();
		for (DBObject dbObject : list) {
			System.out.println(dbObject.toString());
		}
		return null;
	}

}
