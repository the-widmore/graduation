package com.ccniit.graduation.pojo.qo;

public class VoterQuery extends PagedQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6761339918352166728L;
	private long author;
	private long voterGroup;

	public VoterQuery() {
		super();
	}

	public VoterQuery(long offset, int pageSize) {
		super(offset, pageSize);
	}

	public VoterQuery(long author, long voterGroup) {
		super();
		this.author = author;
		this.voterGroup = voterGroup;
	}

	public long getAuthor() {
		return author;
	}

	public void setAuthor(long author) {
		this.author = author;
	}

	public long getVoterGroup() {
		return voterGroup;
	}

	public void setVoterGroup(long voterGroup) {
		this.voterGroup = voterGroup;
	}

}
