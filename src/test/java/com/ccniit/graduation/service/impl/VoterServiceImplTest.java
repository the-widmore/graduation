package com.ccniit.graduation.service.impl;

import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.plus.poi.ParseVotersFromExcel;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.service.VoterService;

public class VoterServiceImplTest extends BaseTest {

	private static final String TEST_DOC = "K:/LinkmanUploadTemplate.xls";

	@Resource
	VoterService voterService;
	@Resource
	ParseVotersFromExcel parseVotersFromExcel;

	@Test
	@Transactional()
	@Rollback(true)
	public void testInsertVoters() throws IException {
		String[] params = { TEST_DOC };
		List<Voter> voters = parseVotersFromExcel.parse(params);

		int inserted = voterService.insertVoters(voters);
		Assert.assertEquals(3, inserted);
	}

	@Test
	public void testDeleteVoter() {
		fail("Not yet implemented");
	}

}
