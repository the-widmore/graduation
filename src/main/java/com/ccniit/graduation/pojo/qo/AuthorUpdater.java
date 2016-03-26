package com.ccniit.graduation.pojo.qo;

import java.io.Serializable;

public class AuthorUpdater implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1389573619117598504L;
	private long id;

	public AuthorUpdater() {
		super();
	}

	public AuthorUpdater(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
