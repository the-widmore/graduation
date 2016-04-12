package com.ccniit.graduation.pojo.qo;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

public class VotePublishVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8671484106740580604L;
	private long voteId;
	private String title;
	// private String endDate;
	private Date endDate;
	private String authType;
	private File cover;

	public VotePublishVo() {
		super();
	}

	public VotePublishVo(long voteId, String title, Date endDate, String authType, File cover) {
		super();
		this.voteId = voteId;
		this.endDate = endDate;
		this.authType = authType;
		this.cover = cover;
	}

	public long getVoteId() {
		return voteId;
	}

	public void setVoteId(long voteId) {
		this.voteId = voteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return "VotePublishVo [voteId=" + voteId + ", title=" + title + ", endDate=" + endDate + ", authType="
				+ authType + ", cover=" + cover + "]";
	}

}
