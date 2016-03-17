package com.ccniit.graduation.plus.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.pojo.db.Voter;

@Component("voterParseFromExcel")
public class VoterParseFromExcel {

	private static final Logger LOG = LoggerFactory.getLogger(VoterParseFromExcel.class);

	public List<Voter> parse(String path) {
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(new FileInputStream(path));

			for (int s = 0; s < workbook.getNumberOfSheets(); s++) {
				Sheet sheet = workbook.getSheetAt(s);
				for (int i = 0; i < sheet.getLastRowNum(); i++) {
					Row row = sheet.getRow(i);
					for (int j = 0; j < row.getLastCellNum(); j++) {
						Cell cell = row.getCell(j);
						LOG.debug("Address:{} Value:{}", cell.getAddress(), getCellValue(cell));
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				LOG.error("关闭Excel失败", e);
			}
		}

		return null;
	}

	private Object getCellValue(Cell cell) {
		Object value = null;

		int cellType = cell.getCellType();

		try {
			switch (cellType) {
			case Cell.CELL_TYPE_STRING:
				value = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				value = cell.getNumericCellValue();
			default:
				value = cell.getAddress();
				break;
			}
		} catch (NullPointerException e) {
			LOG.error("{}cell is null.", cell.getAddress());
		}

		return value;
	}

}
