package com.ccniit.graduation.pojo.db;

import java.io.Serializable;
import java.util.Date;

public class Vote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1590936135125667970L;
	private long id;
	private String tableName;
	private String category;
	private long author;
	private String title;
	private int progress;
	private Date inDate;
	private Date predictDate;
	private Date endDate;

	public Vote() {
		super();
		Date now = new Date();
		this.inDate = now;
		this.endDate = now;
	}

	public Vote(String tableName, String category, long author, String title, Date predictDate) {
		super();
		this.tableName = tableName;
		this.category = category;
		this.author = author;
		this.title = title;
		this.predictDate = predictDate;
		Date now = new Date();
		this.inDate = now;
		this.endDate = now;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getAuthor() {
		return author;
	}

	public void setAuthor(long author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getPredictDate() {
		return predictDate;
	}

	public void setPredictDate(Date predictDate) {
		this.predictDate = predictDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}