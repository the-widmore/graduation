package com.ccniit.graduation.pojo.common;

import java.io.Serializable;

public class VoteCountByCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6420538051607382368L;
	private String category;
	private int counter;

	public VoteCountByCategory() {
		super();
	}

	public VoteCountByCategory(String category, int counter) {
		super();
		this.category = category;
		this.counter = counter;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {
		return "VoteCategoryCount [category=" + category + ", counter=" + counter + "]";
	}

}
