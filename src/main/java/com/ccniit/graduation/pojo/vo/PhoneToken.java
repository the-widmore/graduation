package com.ccniit.graduation.pojo.vo;

public class PhoneToken implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3319673689565717807L;
	private String phone;
	private String password;

	public PhoneToken() {
		super();
	}

	public PhoneToken(String phone, String password) {
		super();
		this.phone = phone;
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
