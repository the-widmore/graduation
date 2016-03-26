package com.ccniit.graduation.pojo.qo;

/**
 * Author个人基本信息更新器，主要是密码和电话
 */
public class AuthorBaseUpdater extends AuthorUpdater {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2992520029775406342L;
	private String email;
	private String phone;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	private String secondPassword;

	public AuthorBaseUpdater() {
		super();
	}

	public AuthorBaseUpdater(String email, String phone, String oldPassword, String newPassword, String confirmPassword,
			String secondPassword) {
		super();
		this.email = email;
		this.phone = phone;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
		this.secondPassword = secondPassword;
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getSecondPassword() {
		return secondPassword;
	}

	public void setSecondPassword(String secondPassword) {
		this.secondPassword = secondPassword;
	}

}
