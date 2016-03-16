package com.ccniit.graduation.pojo.vo;

import java.io.Serializable;

public class VoterQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3302872562908414725L;
	private long voterGroup;
	private int page;
	private int offset;
	private int pageSize;

	private static final int DEFAULT_PAGE_SIZE = 50;

	public VoterQuery() {
		super();
		this.pageSize = DEFAULT_PAGE_SIZE;
		this.offset = DEFAULT_PAGE_SIZE * page;
	}

	public VoterQuery(long voterGroup, int page) {
		super();
		this.voterGroup = voterGroup;
		this.page = page;
		this.pageSize = DEFAULT_PAGE_SIZE;
		this.offset = DEFAULT_PAGE_SIZE * page;
	}

	public long getVoterGroup() {
		return voterGroup;
	}

	public void setVoterGroup(long voterGroup) {
		this.voterGroup = voterGroup;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
