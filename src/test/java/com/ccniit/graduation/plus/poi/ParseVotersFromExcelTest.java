package com.ccniit.graduation.plus.poi;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.exception.IException;

public class ParseVotersFromExcelTest extends BaseTest {

	private static final String TEST_DOC = "K:/LinkmanUploadTemplate.xls";

	@Resource
	ParseVotersFromExcel parseVotersFromExcel;

	@Test
	public void testParse() throws IException {
		String[] params = { TEST_DOC };
		parseVotersFromExcel.parse(params);
	}

}
