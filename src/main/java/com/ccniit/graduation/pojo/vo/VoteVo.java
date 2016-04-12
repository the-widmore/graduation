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
	private String action;
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

	public String getAction() {
		return action;
	}

	public void setAction(String actions) {
		this.action = actions;
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

	@Override
	public String toString() {
		return "VoteVo [id=" + id + ", title=" + title + ", progress=" + progress + ", action=" + action + ", tags="
				+ tags + ", inDate=" + inDate + "]";
	}

}
