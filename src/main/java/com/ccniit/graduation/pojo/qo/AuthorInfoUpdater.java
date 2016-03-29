package com.ccniit.graduation.pojo.qo;

/**
 * Author扩展信息更新器
 * 
 */
public class AuthorInfoUpdater extends AuthorUpdater {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1146015745629816506L;
	private String company;
	private String address;
	private String work;
	private String descriptionSelf;

	public AuthorInfoUpdater() {
		super();
	}

	public AuthorInfoUpdater(long id) {
		super(id);
	}

	public AuthorInfoUpdater(String company, String address, String work, String descriptionSelf) {
		super();
		this.company = company;
		this.address = address;
		this.work = work;
		this.descriptionSelf = descriptionSelf;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

}
