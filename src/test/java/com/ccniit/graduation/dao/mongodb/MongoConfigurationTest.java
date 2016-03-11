package com.ccniit.graduation.dao.mongodb;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.doc.VoteData;

public class MongoConfigurationTest extends BaseTest {

	@Test
	public void testMongoDB() {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringMongoConfig.class);

		MongoOperations operations = context.getBean("mongoTemplate", MongoOperations.class);

		VoteData data = new VoteData();
		Map<String, String[]> dataMap = new HashMap<String, String[]>();
		String[] array1 = { "A,B" };
		dataMap.put("1", array1);
		String[] array2 = { "D" };
		dataMap.put("2", array2);
		data.setData(dataMap);

		operations.save(data);

	}

}
