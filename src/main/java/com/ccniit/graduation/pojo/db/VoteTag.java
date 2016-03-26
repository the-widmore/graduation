package com.ccniit.graduation.pojo.db;

import java.io.Serializable;

public class VoteTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5136278183338008490L;
	private long id;
	private String tag;

	public VoteTag() {
		super();
	}

	public VoteTag(String tag) {
		super();
		this.tag = tag;
	}

	public VoteTag(int id, String tag) {
		super();
		this.id = id;
		this.tag = tag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
