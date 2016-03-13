package com.ccniit.graduation.pojo.common;

public class UserToken {

	private String email;
	private String password;

	public UserToken(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public UserToken() {
		// TODO Auto-generated constructor stub
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

}
