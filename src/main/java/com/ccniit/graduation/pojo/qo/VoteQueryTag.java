package com.ccniit.graduation.pojo.qo;

public class VoteQueryTag extends BaseQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1182525189855440221L;
	private String tag;

	public VoteQueryTag() {
		super();
	}

	public VoteQueryTag(long offset, int pageSize) {
		super(offset, pageSize);
	}

	public VoteQueryTag(String tag) {
		super();
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
