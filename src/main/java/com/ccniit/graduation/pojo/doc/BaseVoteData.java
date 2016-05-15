package com.ccniit.graduation.pojo.doc;

import java.io.Serializable;
import java.util.Map;

public class BaseVoteData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4162660588463836506L;
	protected Map<String, String[]> data;
	protected long inDate;

	public BaseVoteData() {
		super();
		this.inDate = System.currentTimeMillis();

	}

	public BaseVoteData(Map<String, String[]> data) {
		super();
		this.data = data;
		this.inDate = System.currentTimeMillis();
	}

	public Map<String, String[]> getData() {
		return data;
	}

	public void setData(Map<String, String[]> data) {
		this.data = data;
	}

	public long getInDate() {
		return inDate;
	}

	public void setInDate(long inDate) {
		this.inDate = inDate;
	}

	@Override
	public String toString() {
		return "BaseVoteData [data=" + data + ", inDate=" + data + "]";
	}

}
