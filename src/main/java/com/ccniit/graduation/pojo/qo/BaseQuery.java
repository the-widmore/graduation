package com.ccniit.graduation.pojo.qo;

import java.io.Serializable;

public class BaseQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6960197778217633204L;
	private long offset;
	private int pageSize;

	public BaseQuery() {
		super();
	}

	public BaseQuery(long offset, int pageSize) {
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
