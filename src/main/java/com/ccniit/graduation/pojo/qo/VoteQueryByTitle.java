package com.ccniit.graduation.pojo.qo;

public class VoteQueryByTitle extends PagedQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8343399174401588971L;
	private String title;

	public VoteQueryByTitle() {
		super();
	}

	public VoteQueryByTitle(String title) {
		super();
		this.title = title;
	}

	public VoteQueryByTitle(long offset, int pageSize) {
		super(offset, pageSize);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
