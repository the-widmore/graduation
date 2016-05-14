package com.ccniit.graduation.pojo.db;

public class Author implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 386062764883300692L;
	private Long id;
	private String email;
	private String phone;
	private String password;
	private String secondPassword;
	private String name;
	private String nickname;
	private String sex;
	private String status;

	public Author() {
		super();
	}

	public Author(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Author(String email, String password, String nickname) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecondPassword() {
		return secondPassword;
	}

	public void setSecondPassword(String secondPassword) {
		this.secondPassword = secondPassword;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", email=" + email + ", nickname=" + nickname + ", status=" + status + "]";
	}

}
