package com.ccniit.graduation.helper;

import java.io.Serializable;

public class Paging implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5724189422710522480L;
	private int counter;/* 总共记录数 */
	private int pageSize;/* 显示的条数 */
	private int currentPage;/* 当前页数 */
	private String pagingURL;/* url */

	public Paging() {
		super();
	}

	public Paging(int counter, int pageSize, int currentPage) {
		super();
		this.counter = counter;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getPagingURL() {
		return pagingURL;
	}

	public void setPagingURL(String pagingURL) {
		this.pagingURL = pagingURL;
	}

}
