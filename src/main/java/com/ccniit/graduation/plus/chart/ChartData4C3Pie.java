package com.ccniit.graduation.plus.chart;

import java.io.Serializable;
import java.util.List;

/**
 * C3JS 图表 数据
 */
public class ChartData4C3Pie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8141269092491924317L;
	private List<List<Object>> columns;

	public ChartData4C3Pie() {
		super();
	}

	public ChartData4C3Pie(List<List<Object>> columns) {
		super();
		this.columns = columns;
	}

	public List<List<Object>> getColumns() {
		return columns;
	}

	public void setColumns(List<List<Object>> columns) {
		this.columns = columns;
	}
}
