package com.ccniit.graduation.dao.mongodb;

import java.util.HashMap;
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
import com.ccniit.graduation.util.LoggerUtils;
import com.ccniit.graduation.util.StringUtils;

public class MongoConfigurationTest extends BaseTest {

	private Logger LOG = LoggerUtils.getDev();

	@Resource
	MongoTemplate mongoTemplate;

	@Test
	public void mongoDBConfigTest() {
		Set<String> collections = mongoTemplate.getCollectionNames();

		for (String collectionName : collections) {
			LOG.info(collectionName);
			mongoTemplate.dropCollection(collectionName);
		}

	}

	private static final int INSERT_TEST_TIMES = 100;
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
			// mongoTemplate.insert(voteData, "_" + StringUtils.getUUID());
			mongoTemplate.save(voteData, "_" + StringUtils.getUUID());
		}

	}

	private Map<String, String[]> random() {
		Map<String, String[]> data = new HashMap<>();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {

			int valueSize = random.nextInt(3);
			String[] set = new String[valueSize];
			for (int j = 0; j < set.length; j++) {
				set[i] = RandomStringUtils.random(1, CHARS);
			}

			data.put("q" + i, set);
		}
		return data;
	}

}
