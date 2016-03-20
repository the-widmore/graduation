package com.ccniit.graduation.dao.mongodb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.doc.PrivateVoteData;
import com.ccniit.graduation.util.StringUtils;
import com.mongodb.DBCollection;

public class MongoConfigurationTest extends BaseTest {

	private Logger LOG = getLog();

	@Override
	public Logger getLog() {
		return super.getLog();
	}

	@Resource
	MongoTemplate mongoTemplate;

	@Test
	public void mongoDBConfigTest() {
		Set<String> collections = mongoTemplate.getCollectionNames();

		for (String coll : collections) {
			LOG.info(coll);
		}

	}

	private static final int INSERT_TEST_TIMES = 100000;
	public static final char[] CHARS = { 'A', 'B', 'C', 'D' };

	@Test
	public void saveDocTest() {
		// VoteDataDoc voteData = new VoteDataDoc();

		// # Test 01
		// voteData.setData(data);
		// mongoTemplate.insert(voteData);
		// voteData.setData(data);

		// # Test 02
		// String collectionName = StringUtils.getUUID();
		// VoteDataDoc voteDataDoc = new VoteDataDoc();
		// voteDataDoc.setVote(1);
		// voteDataDoc.setCollectionName(collectionName);
		// mongoTemplate.save(voteDataDoc, voteDataDoc.getCollectionName());
		// LOG.info("{}", collectionName);

		// # Test 03
		for (int i = 0; i < INSERT_TEST_TIMES; i++) {
			PrivateVoteData voteData = new PrivateVoteData("chenyiyuan00@gmail.com", 2130706433L);
			voteData.setData(random());
			mongoTemplate.insert(voteData, "_" + StringUtils.getUUID());
		}

	}

	private Map<String, List<String>> random() {
		Map<String, List<String>> data = new HashMap<>();
		Random random = new Random();
		for (int i = 0; i < 100; i++) {

			int valueSize = random.nextInt(3);

			List<String> value = new ArrayList<>();
			for (int j = 0; j < valueSize; j++) {
				value.add(RandomStringUtils.random(1, CHARS));
			}

			data.put(String.valueOf(i), value);
		}
		return data;
	}

}
