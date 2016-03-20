package com.ccniit.graduation.pojo.doc;

public class PrivateVoteData extends BaseVoteData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 909622868500483563L;
	private String email;
	private long ip;

	public PrivateVoteData() {
		super();
	}

	public PrivateVoteData(String email, long ip) {
		super();
		this.email = email;
		this.ip = ip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIp() {
		return ip;
	}

	public void setIp(long ip) {
		this.ip = ip;
	}

}
