package com.ccniit.graduation.pojo.vo;

import java.io.Serializable;

public class VoterGroupVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7504074160450725545L;
	private long id;
	private String description;
	private int quantity;
	private String inDate;

	public VoterGroupVo() {
		super();
	}

	public VoterGroupVo(long id, String description, int quantity, String inDate) {
		super();
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.inDate = inDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

}
