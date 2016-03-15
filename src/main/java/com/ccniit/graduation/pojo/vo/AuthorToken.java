package com.ccniit.graduation.pojo.vo;

import java.io.Serializable;

import com.ccniit.graduation.exception.IException;

public class AuthorToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5820360764412739143L;

	static enum CertificateType {
		EMAIL, TEL
	}

	private String certificate;
	private char[] password;

	public AuthorToken(String certificate, char[] password) throws IException {
		super();
		this.certificate = certificate;
		this.password = password;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

}
