package com.ccniit.graduation.pojo.qo;

import java.io.Serializable;

/**
 * 创建Vote的属性
 */
public class VoteCreater implements Serializable {

	public static enum VoteEditMode {
		html, visible
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5230925991607473130L;
	private Long author;
	private String title;
	private String tags;

	private String editMode;// 编辑模式

	public VoteCreater() {
		super();
	}

	public VoteCreater(Long author, String title, String tags, String editMode) {
		super();
		this.author = author;
		this.title = title;
		this.tags = tags;
		this.editMode = editMode;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getEditMode() {
		return editMode;
	}

	public void setEditMode(String editMode) {
		this.editMode = editMode;
	}

}
