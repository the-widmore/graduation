package com.ccniit.graduation.pojo.doc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class VoteDataDoc implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4662151526584923945L;
	private long vote;
	private String collectionName;
	private Map<String, List<String>> data;
	private long inDate;

	public VoteDataDoc() {
		super();
		this.inDate = System.currentTimeMillis();
	}

	public VoteDataDoc(long vote, String collectionName, Map<String, List<String>> data) {
		super();
		this.vote = vote;
		this.collectionName = collectionName;
		this.data = data;
		this.inDate = System.currentTimeMillis();
	}

	public long getVote() {
		return vote;
	}

	public void setVote(long vote) {
		this.vote = vote;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public Map<String, List<String>> getData() {
		return data;
	}

	public void setData(Map<String, List<String>> data) {
		this.data = data;
	}

	public long getInDate() {
		return inDate;
	}

	public void setInDate(long inDate) {
		this.inDate = inDate;
	}

}
