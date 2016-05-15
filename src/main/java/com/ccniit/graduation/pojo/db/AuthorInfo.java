package com.ccniit.graduation.pojo.db;

import java.io.Serializable;
import java.util.Date;

public class AuthorInfo implements Serializable {

	/**
	 * 通知优先方式
	 */
	public static enum PrimaryNofify {
		/** 电子邮箱优先 */
		EMAIL,
		/** 手机短信优先 */
		PHONE,
		/** 电子邮箱和短信 */
		BOTH
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4983288534328571940L;
	private long id;
	private String company;
	private String work;
	private String descriptionSelf;
	private boolean setLinkmanNotify;
	private boolean setFinishNotify;
	private boolean setDataExpireNotify;
	private String setPrimaryNofify;
	private Date inDate;

	public AuthorInfo() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getDescriptionSelf() {
		return descriptionSelf;
	}

	public void setDescriptionSelf(String descriptionSelf) {
		this.descriptionSelf = descriptionSelf;
	}

	public boolean isSetLinkmanNotify() {
		return setLinkmanNotify;
	}

	public void setSetLinkmanNotify(boolean setLinkmanNotify) {
		this.setLinkmanNotify = setLinkmanNotify;
	}

	public boolean isSetFinishNotify() {
		return setFinishNotify;
	}

	public void setSetFinishNotify(boolean setFinishNotify) {
		this.setFinishNotify = setFinishNotify;
	}

	public boolean isSetDataExpireNotify() {
		return setDataExpireNotify;
	}

	public void setSetDataExpireNotify(boolean setDataExpireNotify) {
		this.setDataExpireNotify = setDataExpireNotify;
	}

	public String getSetPrimaryNofify() {
		return setPrimaryNofify;
	}

	public void setSetPrimaryNofify(String setPrimaryNofify) {
		this.setPrimaryNofify = setPrimaryNofify;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

}
