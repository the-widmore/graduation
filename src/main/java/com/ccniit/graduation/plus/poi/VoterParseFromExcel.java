package com.ccniit.graduation.plus.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
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

		List<Voter> voters = new ArrayList<>();
		POIFSFileSystem poifsFileSystem = null;
		try {
			poifsFileSystem = new POIFSFileSystem(new FileInputStream(path));
			workbook = new HSSFWorkbook(poifsFileSystem);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		Row row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// 正文内容应该从第二行开始,第一行为表头的标题
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			while (j < colNum) {
				// 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
				// 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
				// str += getStringCellValue(row.getCell((short) j)).trim() +
				// "-";
				Cell cell = row.getCell(j);
				LOG.info("{}:{}", cell.getAddress(), cell.getStringCellValue());
				j++;
			}
		}
		return voters;
	}

	public void readXls(String path) throws IOException {
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}

			// 循环行Row
			for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}

				// 循环列Cell
				for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
					HSSFCell hssfCell = hssfRow.getCell(cellNum);
					if (hssfCell == null) {
						continue;
					}

					System.out.print(" - " + getValue(hssfCell));
				}
				System.out.println();
			}
		}

		hssfWorkbook.close();
	}

	private String getValue(HSSFCell hssfCell) {
		Object result = null;

		int cellType = hssfCell.getCellType();
		switch (cellType) {
		case HSSFCell.CELL_TYPE_BOOLEAN:
			result = hssfCell.getBooleanCellValue();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			result = hssfCell.getNumericCellValue();
			break;
		default:
			result = hssfCell.getStringCellValue();
			break;
		}
		return result.toString();
	}

}
