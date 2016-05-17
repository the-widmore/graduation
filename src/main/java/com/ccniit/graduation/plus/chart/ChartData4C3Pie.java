package com.ccniit.graduation.plus.chart;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * C3JS 图表 数据
 */
public class ChartData4C3Pie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8141269092491924317L;
	private List<Map<String, List<Object>>> columns;

	public ChartData4C3Pie() {
		super();
	}

	public List<Map<String, List<Object>>> getColumns() {
		return columns;
	}

	public void setColumns(List<Map<String, List<Object>>> columns) {
		this.columns = columns;
	}

}
