package com.ccniit.graduation.pojo.db;

import java.io.Serializable;

public class VoteTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5136278183338008490L;
	private int id;
	private String tag;

	public VoteTag() {
		super();
	}

	public VoteTag(int id, String tag) {
		super();
		this.id = id;
		this.tag = tag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
