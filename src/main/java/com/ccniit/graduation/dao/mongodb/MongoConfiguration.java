package com.ccniit.graduation.dao.mongodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

	public static final String DB_NAME = "graduation";
	public static final String DB_HOST = "127.0.0.1";

	@Override
	protected String getDatabaseName() {
		return DB_NAME;
	}

	@Bean
	@Override
	public Mongo mongo() throws Exception {
		Mongo mongo = new MongoClient(DB_HOST);
		return mongo;
	}

}
