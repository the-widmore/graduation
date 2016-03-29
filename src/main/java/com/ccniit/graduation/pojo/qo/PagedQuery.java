package com.ccniit.graduation.pojo.qo;

import java.io.Serializable;

/**
 * 需要分页的查询
 * 
 * @field offset 查询的索引
 * @field pageSize 一次查询的条数
 */
public class PagedQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6960197778217633204L;
	protected long offset;
	protected int pageSize;

	public PagedQuery() {
		super();
	}

	public PagedQuery(long offset, int pageSize) {
		super();
		this.offset = offset;
		this.pageSize = pageSize;
	}

	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
