package com.ccniit.graduation.pojo.db;

import java.io.Serializable;

public class VoteVoterGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1126488490575946297L;
	private long id;
	private long vote;
	private long voterGroup;

	public VoteVoterGroup() {
		super();
	}

	public VoteVoterGroup(long vote, long voterGroup) {
		super();
		this.vote = vote;
		this.voterGroup = voterGroup;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVote() {
		return vote;
	}

	public void setVote(long vote) {
		this.vote = vote;
	}

	public long getVoterGroup() {
		return voterGroup;
	}

	public void setVoterGroup(long voterGroup) {
		this.voterGroup = voterGroup;
	}

}
