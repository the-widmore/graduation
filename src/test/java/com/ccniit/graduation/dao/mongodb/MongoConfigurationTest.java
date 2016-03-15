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
import org.springframework.data.mongodb.core.MongoTemplate;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.doc.VoteData;

public class MongoConfigurationTest extends BaseTest {

	// TODO

	@Resource
	MongoTemplate mongoTemplate;

	@Test
	public void mongoDBConfigTest() {
		Set<String> collections = mongoTemplate.getCollectionNames();

		for (String coll : collections) {
			System.out.println(coll);
		}
	}

	private static final int INSERT_TEST_TIMES = 10000;
	public static final char[] CHARS = { 'A', 'B', 'C', 'D' };

	@Test
	public void saveDocTest() {
		VoteData voteData = new VoteData();

		Map<String, List<String>> data = new HashMap<>();
		Random random = new Random();
		for (int i = 0; i < INSERT_TEST_TIMES; i++) {

			int valueSize = random.nextInt(3);

			List<String> value = new ArrayList<>();
			for (int j = 0; j < valueSize; j++) {
				value.add(RandomStringUtils.random(1, CHARS));
			}

			data.put(String.valueOf(i), value);
		}

		voteData.setData(data);

		mongoTemplate.insert(voteData);
	}

}
