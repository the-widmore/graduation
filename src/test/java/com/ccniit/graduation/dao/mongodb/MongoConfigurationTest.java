package com.ccniit.graduation.dao.mongodb;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.ccniit.graduation.BaseTest;

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

}
