package com.ccniit.graduation.pojo.common;

import java.io.Serializable;
import java.util.List;

public class DataGrid<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7606651445484913469L;
	private int totle;
	private List<T> rows;

	public DataGrid() {
		super();
	}

	public DataGrid(int totle, List<T> rows) {
		super();
		this.totle = totle;
		this.rows = rows;
	}

	public int getTotle() {
		return totle;
	}

	public void setTotle(int totle) {
		this.totle = totle;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
