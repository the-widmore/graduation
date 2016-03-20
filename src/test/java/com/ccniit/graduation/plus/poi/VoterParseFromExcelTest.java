package com.ccniit.graduation.plus.poi;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;

public class VoterParseFromExcelTest extends BaseTest {

	private static final String PATH = "K:/LinkmanUploadTemplate.xls";

	@Resource
	VoterParseFromExcel voterParseFromExcel;

	@Test
	public void testParse() {

		voterParseFromExcel.parse(PATH);

	}

	@Test
	public void testReadXls() throws IOException {

		voterParseFromExcel.readXls(PATH);

	}

}
