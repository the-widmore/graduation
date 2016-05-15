package com.ccniit.graduation.plus.poi;

import java.io.Serializable;

public class ExcelVoterParseTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3530963773247523428L;
	private Long author;
	private String excelPath;

	public ExcelVoterParseTask() {
		super();
	}

	public ExcelVoterParseTask(Long author, String excelPath) {
		super();
		this.author = author;
		this.excelPath = excelPath;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

	public String getExcelPath() {
		return excelPath;
	}

	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}

}
