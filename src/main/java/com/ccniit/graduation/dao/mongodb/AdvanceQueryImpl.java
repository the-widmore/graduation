package com.ccniit.graduation.dao.mongodb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.pojo.doc.BaseVoteData;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

@Service("advanceQuery")
public class AdvanceQueryImpl implements IAdvanceQuery {

	@Resource
	MongoTemplate mongoTemplate;

	@Override
	public List<BaseVoteData> findAllByField(String collectionName, String field) {
		DBCollection collections = mongoTemplate.getCollection(collectionName);
		collections.find(null, new BasicDBObject(field, true)).toArray();
		Query query = new Query();
		query.fields().include(field);
		return mongoTemplate.find(query, BaseVoteData.class, collectionName);
	}

}
