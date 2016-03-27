package com.ccniit.graduation.pojo.vo;

import java.io.Serializable;

/**
 * Vote搜索结果对象
 */
public class VoteSearchResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4292500902441747694L;
	private long id;// Vote.id
	private String title;// 标题
	private String tags;// 所有标签
	private String cover;// 封面

	public VoteSearchResult() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

}
