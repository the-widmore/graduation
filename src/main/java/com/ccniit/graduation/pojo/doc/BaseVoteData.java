package com.ccniit.graduation.pojo.doc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BaseVoteData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4162660588463836506L;
	protected Map<String, List<String>> data;
	protected long inDate;

	public BaseVoteData() {
		super();
		this.inDate = System.currentTimeMillis();

	}

	public BaseVoteData(Map<String, List<String>> data) {
		super();
		this.data = data;
		this.inDate = System.currentTimeMillis();
	}

	public Map<String, List<String>> getData() {
		return data;
	}

	public void setData(Map<String, List<String>> data) {
		this.data = data;
	}

	public long getInDate() {
		return inDate;
	}

	public void setInDate(long inDate) {
		this.inDate = inDate;
	}

}
