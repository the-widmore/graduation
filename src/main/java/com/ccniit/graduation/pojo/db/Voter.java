package com.ccniit.graduation.pojo.db;

import java.io.Serializable;

public class Voter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1399569389959295577L;
	private long id;
	private long voterGroupId;
	private String email;
	private String phone;
	private String alias;

	public Voter() {
		super();
	}

	public Voter(long voterGroupId, String email, String phone, String alias) {
		super();
		this.voterGroupId = voterGroupId;
		this.email = email;
		this.phone = phone;
		this.alias = alias;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
