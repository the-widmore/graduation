package com.ccniit.graduation.pojo.db;

public class Voter {

	private long voterGroupId;
	private String email;
	private String alias;

	public Voter() {
		super();
	}

	public Voter(long voterGroupId, String email, String alias) {
		super();
		this.voterGroupId = voterGroupId;
		this.email = email;
		this.alias = alias;
	}

	public long getVoterGroupId() {
		return voterGroupId;
	}

	public void setVoterGroupId(long voterGroupId) {
		this.voterGroupId = voterGroupId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
