package com.ccniit.graduation.pojo.db;

import java.io.Serializable;

public class AuthCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7942143450502855049L;
	private Long id;
	private Long vote;
	private Long voter;
	private String code;
	private boolean used;

	public AuthCode() {
		super();
	}

	public AuthCode(Long vote) {
		super();
		this.vote = vote;
	}

	public AuthCode(Long vote, Long voter, String code) {
		super();
		this.vote = vote;
		this.voter = voter;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVote() {
		return vote;
	}

	public void setVote(Long vote) {
		this.vote = vote;
	}

	public Long getVoter() {
		return voter;
	}

	public void setVoter(Long voter) {
		this.voter = voter;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

}
