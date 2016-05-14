package com.ccniit.graduation.pojo.db;

import java.io.Serializable;

import com.ccniit.graduation.exception.ParamsException;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Voter implements Serializable {

	public static enum VoterField {
		/** 邮件 */
		email,
		/** 手机 */
		phone,
		/** 备注 */
		alias
	}

	public static VoterField voterField(String field) throws ParamsException {
		if (VoterField.email.toString().equals(field)) {
			return VoterField.email;
		} else if (VoterField.phone.toString().equals(field)) {
			return VoterField.phone;
		} else if (VoterField.alias.toString().equals(field)) {
			return VoterField.alias;
		} else {
			throw new ParamsException("Error param ,mast be email,phon or alias.");
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1399569389959295577L;
	private long id;
	private long voterGroup;
	private String email;
	private String phone;
	private String alias;

	public Voter() {
		super();
	}

	public Voter(long voterGroup, String email, String phone, String alias) {
		super();
		this.voterGroup = voterGroup;
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
		return voterGroup;
	}

	@JsonIgnore
	public void setVoterGroupId(long voterGroup) {
		this.voterGroup = voterGroup;
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

	@Override
	public String toString() {
		return "Voter [email=" + email + ", phone=" + phone + ", alias=" + alias + "]";
	}

}
