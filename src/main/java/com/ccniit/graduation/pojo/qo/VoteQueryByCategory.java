package com.ccniit.graduation.pojo.qo;

/**
 * 按照类型查询Vote，继承自分页查询
 */
public class VoteQueryByCategory extends PagedQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6795647002666502748L;
	private Long author;
	private String category;

	public VoteQueryByCategory() {
		super();
	}

	public VoteQueryByCategory(long offset, int pageSize) {
		super(offset, pageSize);
	}

	public VoteQueryByCategory(Long author, String category) {
		super();
		this.author = author;
		this.category = category;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
