package com.ccniit.graduation.pojo.db;

import java.io.Serializable;

/**
 * Vote的问题定义对象
 * 
 * @field id(Vote.id)
 * @field content(问题)
 */
public class VoteContent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1798830415435049268L;
	private Long id;
	private String content;

	public VoteContent() {
		super();
	}

	public VoteContent(String content) {
		super();
		this.content = content;
	}

	public VoteContent(Long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
