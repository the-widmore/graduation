package com.ccniit.graduation.pojo.qo;

public class VoterQuery extends PagedQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6761339918352166728L;
	private Long author;
	private Long voterGroup;

	public VoterQuery() {
		super();
	}

	public VoterQuery(long author, long voterGroup) {
		super();
		this.author = author;
		this.voterGroup = voterGroup;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(long author) {
		this.author = author;
	}

	public Long getVoterGroup() {
		return voterGroup;
	}

	public void setVoterGroup(long voterGroup) {
		this.voterGroup = voterGroup;
	}

	@Override
	public String toString() {
		return "VoterQuery [author=" + author + ", voterGroup=" + voterGroup + ", offset=" + offset + ", pageSize="
				+ pageSize + "]";
	}

}
