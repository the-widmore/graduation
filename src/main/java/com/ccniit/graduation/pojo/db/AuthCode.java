package com.ccniit.graduation.pojo.db;

import java.io.Serializable;

public class AuthCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7942143450502855049L;
	private long id;
	private long vote;
	private long voter;
	private int code;
	private boolean used;

	public AuthCode() {
		super();
	}

	public AuthCode(long vote) {
		super();
		this.vote = vote;
	}

	public AuthCode(long vote, long voter, int code) {
		super();
		this.vote = vote;
		this.voter = voter;
		this.code = code;
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

	public long getVoter() {
		return voter;
	}

	public void setVoter(long voter) {
		this.voter = voter;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

}
