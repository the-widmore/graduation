package com.ccniit.graduation.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.plus.poi.ParseVotersFromExcel;
import com.ccniit.graduation.pojo.common.VoterGroupData;
import com.ccniit.graduation.pojo.qo.VoterQuery;
import com.ccniit.graduation.resource.Commons;
import com.ccniit.graduation.service.VoterService;

public class VoterServiceImplTest extends BaseTest {

	private static final String TEST_DOC = "K:/LinkmanUploadTemplate.xls";

	private static final Long TEST_VOTER_GROUP_ID = 4L;

	@Resource
	VoterService voterService;
	@Resource
	ParseVotersFromExcel parseVotersFromExcel;

	@Test
	@Transactional()
	@Rollback(true)
	public void testInsertVoters() throws IException {
		String[] params = { TEST_DOC };
		VoterGroupData voterGroupData = parseVotersFromExcel.parse(params);

		int inserted = voterService.insertVoters(voterGroupData.getVoters(), TEST_VOTER_GROUP_ID);
		Assert.assertNotEquals(0, inserted);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteVoter() {
		voterService.deleteVoter(1);
	}

	@Test
	public void testSelectVoterFromVoterGroup() {
		VoterQuery voterQuery = new VoterQuery(1, 1);
		voterQuery.setPageSize(Commons.LINKMAN_PAGE_SIZE);
		voterQuery.setOffset(Commons.LINKMAN_PAGE_SIZE * (1 - 1));

		System.out.println(voterQuery);

		int size = voterService.selectVoterFromVoterGroup(voterQuery).size();
		System.out.println(size);
	}

	@Test
	public void testDistinctVoteVoter() {
		Set<String> emails = voterService.distinctVoteVoter(1L);
		Assert.assertNotEquals(0, emails.size());
	}

}
