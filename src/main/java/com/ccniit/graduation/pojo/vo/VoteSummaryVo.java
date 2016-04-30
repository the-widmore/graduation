package com.ccniit.graduation.pojo.vo;

import java.io.Serializable;

public class VoteSummaryVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 242485496755803685L;
	private String createTime;/* 创建时间 */
	private String surplusTime;/* 剩余时间 */
	private String endTime;/* 预计结束时间时间 */
	private String lastSubmitTime;/* 上次提交时间 */
	private String submitTimes;/* 提交次数(如果是私有,应该以比例形式显示) */
	private String auth;/* 授权类型 */

	public VoteSummaryVo() {

	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSurplusTime() {
		return surplusTime;
	}

	public void setSurplusTime(String surplusTime) {
		this.surplusTime = surplusTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLastSubmitTime() {
		return lastSubmitTime;
	}

	public void setLastSubmitTime(String lastSubmitTime) {
		this.lastSubmitTime = lastSubmitTime;
	}

	public String getSubmitTimes() {
		return submitTimes;
	}

	public void setSubmitTimes(String submitTimes) {
		this.submitTimes = submitTimes;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

}
