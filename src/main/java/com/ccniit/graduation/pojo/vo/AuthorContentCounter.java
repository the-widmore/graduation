package com.ccniit.graduation.pojo.vo;

import java.io.Serializable;

/**
 * author 用户中心，内容管理计数对象
 */
public class AuthorContentCounter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 377006535506262111L;
	private long id;
	private int linkmanCount;// 联系人组个数

	private int pollCount;// 问卷个数
	private int voteCount;// 投票个数
	private int infoCount;// 信息收集个数

	public AuthorContentCounter() {
		super();
	}

	public AuthorContentCounter(long id, int linkmanCount, int pollCount, int voteCount, int infoCount) {
		super();
		this.id = id;
		this.linkmanCount = linkmanCount;
		this.pollCount = pollCount;
		this.voteCount = voteCount;
		this.infoCount = infoCount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLinkmanCount() {
		return linkmanCount;
	}

	public void setLinkmanCount(int linkmanCount) {
		this.linkmanCount = linkmanCount;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public int getPollCount() {
		return pollCount;
	}

	public void setPollCount(int pollCount) {
		this.pollCount = pollCount;
	}

	public int getInfoCount() {
		return infoCount;
	}

	public void setInfoCount(int infoCount) {
		this.infoCount = infoCount;
	}

	@Override
	public String toString() {
		return "AuthorContentCounter [linkmanCount=" + linkmanCount + ", voteCount=" + voteCount + ", pollCount="
				+ pollCount + ", infoCount=" + infoCount + "]";
	}

}
