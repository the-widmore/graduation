package com.ccniit.graduation.pojo.vo;

public class VoteVo {

	private String title;
	private String progress;
	private String tags;
	private String inDate;
	private String endDate;// 预计结束时间OR真实结束时间

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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "VoteVo [title=" + title + ", progress=" + progress + ", tags=" + tags + ", inDate=" + inDate
				+ ", endDate=" + endDate + "]";
	}

}
