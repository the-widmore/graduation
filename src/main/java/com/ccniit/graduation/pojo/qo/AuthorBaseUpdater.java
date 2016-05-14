package com.ccniit.graduation.pojo.qo;

/**
 * Author个人基本信息更新器
 */
public class AuthorBaseUpdater extends AuthorUpdater {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2992520029775406342L;
	private String email;
	private String name;
	private String nickname;
	private String sex;
	private String phone;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	private String secondPassword;

	public AuthorBaseUpdater() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	@Override
	public String toString() {
		return "AuthorBaseUpdater [email=" + email + ", name=" + name + ", nickname=" + nickname + ", sex=" + sex
				+ ", phone=" + phone + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword
				+ ", confirmPassword=" + confirmPassword + ", secondPassword=" + secondPassword + "]";
	}

}
