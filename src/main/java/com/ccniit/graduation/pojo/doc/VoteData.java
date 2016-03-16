package com.ccniit.graduation.pojo.doc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.alibaba.fastjson.JSON;

@Document(collection = "voteDatas")
public class VoteData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6843824247415192373L;
	private long vote;
	private Map<String, List<String>> data;

	public VoteData() {
		super();
	}

	public long getVote() {
		return vote;
	}

	public void setVote(long vote) {
		this.vote = vote;
	}

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
