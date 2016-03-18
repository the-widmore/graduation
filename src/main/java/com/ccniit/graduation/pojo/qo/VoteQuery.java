package com.ccniit.graduation.pojo.qo;

import java.io.Serializable;

public class VoteQuery implements Serializable {

	private static final int DEFAULT_PAGE_SIZE = 20;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1981032166371553140L;
	private String tag;
	private int page;
	private int pageSize;

	public VoteQuery() {
		super();
	}

	public VoteQuery(String tag, int page) {
		super();
		this.tag = tag;
		this.page = page;
		this.pageSize = DEFAULT_PAGE_SIZE;
	}

	public VoteQuery(String tag, int page, int pageSize) {
		super();
		this.tag = tag;
		this.page = page;
		this.pageSize = pageSize;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
