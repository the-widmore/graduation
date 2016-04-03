package com.ccniit.graduation.pojo.vo;

import java.io.Serializable;
import java.util.List;

public class VoteVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2913879808020120607L;
	private Long id;
	private String title;
	private String progress;
	private List<String> tags;
	private String inDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

}
