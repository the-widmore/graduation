package com.ccniit.graduation.plus.chart;

import java.io.Serializable;

public class C3DataMate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5141038181458904761L;
	private String key;
	private Integer value;

	public C3DataMate() {
		super();
	}

	public C3DataMate(String key, Integer value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
