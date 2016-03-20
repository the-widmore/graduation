package com.ccniit.graduation.plus.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HSSFUtils {

	private static final Logger LOG = LoggerFactory.getLogger(HSSFUtils.class);

	private HSSFUtils() {
		super();
	}

	public static Object getCellValue(HSSFCell cell) {
		Object cellValue = null;

		int cellType = cell.getCellType();
		switch (cellType) {
		case HSSFCell.CELL_TYPE_BLANK:
			cellValue = null;
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			cellValue = cell.getBooleanCellValue();
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			cellValue = cell.getErrorCellValue();
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			// TODO
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			cellValue = cell.getNumericCellValue();
			break;

		case HSSFCell.CELL_TYPE_STRING:
			cellValue = cell.getStringCellValue();
			break;
		default:
			LOG.warn("没有找到匹配的类型！");
			break;
		}

		return cellValue;
	}

}
