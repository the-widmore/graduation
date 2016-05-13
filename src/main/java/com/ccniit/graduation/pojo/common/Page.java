/**
* 
 */
package com.ccniit.graduation.pojo.common;

import java.io.Serializable;

/**
 * @Title: Page.java
 * @Description: 分页信息
 * @author chen.zhijun
 * @date 2016年5月13日 下午2:07:25
 * @version V1.0
 */
public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3267878095160472805L;
	private int currentPage;
	private int totalPages;
	private int pageSize;

	public Page() {
		super();
	}

	public Page(int currentPage, int totalPages, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.totalPages = totalPages;
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
