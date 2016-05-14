package com.ccniit.graduation.pojo.vo;

import java.io.Serializable;

/**
 * 用户注册信息
 */
public class UserRegister implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5469126443286115471L;
	private String email;
	private String password;
	private String nickname;
	private String rePassword;
	private String verifyCode;

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@Override
	public String toString() {
		return "UserRegister [email=" + email + ", password=" + password + ", nickname=" + nickname + ", verifyCode="
				+ verifyCode + "]";
	}

}
