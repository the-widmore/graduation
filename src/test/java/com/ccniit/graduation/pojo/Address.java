package com.ccniit.graduation.pojo;

import java.io.Serializable;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3225872389653286740L;
	private String priv;
	private String city;
	private String street;

	public Address() {
		super();
	}

	public Address(String priv, String city, String street) {
		super();
		this.priv = priv;
		this.city = city;
		this.street = street;
	}

	public String getPriv() {
		return priv;
	}

	public void setPriv(String priv) {
		this.priv = priv;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [priv=" + priv + ", city=" + city + ", street=" + street + "]";
	}

}
