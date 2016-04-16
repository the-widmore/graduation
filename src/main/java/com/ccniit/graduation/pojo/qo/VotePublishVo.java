package com.ccniit.graduation.pojo.qo;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class VotePublishVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8671484106740580604L;
	private Long voteId;
	private String title;
	private String endDate;
	private File cover;
	private String authType;

	private List<Long> voteGroup;

	public VotePublishVo() {
		super();
	}

	public VotePublishVo(long voteId, String title, String endDate, String authType, File cover) {
		super();
		this.voteId = voteId;
		this.endDate = endDate;
		this.authType = authType;
		this.cover = cover;
	}

	public Long getVoteId() {
		return voteId;
	}

	public void setVoteId(Long voteId) {
		this.voteId = voteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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

	public List<Long> getVoteGroup() {
		return voteGroup;
	}

	public void setVoteGroup(List<Long> voteGroup) {
		this.voteGroup = voteGroup;
	}

	@Override
	public String toString() {
		return "VotePublishVo [voteId=" + voteId + ", title=" + title + ", endDate=" + endDate + ", authType="
				+ authType + ", cover=" + cover + "]";
	}

}
