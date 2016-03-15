package com.ccniit.graduation.pojo.vo;

import java.io.Serializable;

public class EmailToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 321574840102859985L;
	private String email;
	private String password;

	public EmailToken() {
		super();
	}

	public EmailToken(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EmailToken [email=" + email + ", password=" + password + "]";
	}

}
