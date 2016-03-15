package com.ccniit.graduation.pojo.doc;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.alibaba.fastjson.JSON;

@Document(collection = "voteDatas")
public class VoteData {

	private Map<String, List<String>> data;

	public Map<String, List<String>> getData() {
		return data;
	}

	public void setData(Map<String, List<String>> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(data);
	}

}
