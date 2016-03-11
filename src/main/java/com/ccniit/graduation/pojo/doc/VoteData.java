package com.ccniit.graduation.pojo.doc;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.alibaba.fastjson.JSON;

@Document(collection = "voteData")
public class VoteData {

	private Map<String, String[]> data;

	public Map<String, String[]> getData() {
		return data;
	}

	public void setData(Map<String, String[]> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(data);
	}

}
