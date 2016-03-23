package com.ccniit.graduation.plus.poi;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.common.VoterGroupData;

public class ParseVotersFromExcelTest extends BaseTest {

	private static final String TEST_DOC = "K:/LinkmanUploadTemplate.xls";

	@Resource
	ParseVotersFromExcel parseVotersFromExcel;

	@Test
	public void testParse() throws IException {
		String[] params = { TEST_DOC };
		VoterGroupData data = parseVotersFromExcel.parse(params);
		System.out.println(data.getVoterGroupDescription());
	}

}
