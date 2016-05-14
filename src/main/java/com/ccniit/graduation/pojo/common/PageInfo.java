package com.ccniit.graduation.pojo.common;

import java.io.Serializable;

public class PageInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7870549599269006340L;
	private int currentPage;
	private int totalPage;

	public PageInfo() {
		super();
	}

	public PageInfo(int currentPage, int totalPage) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
