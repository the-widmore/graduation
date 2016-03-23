package com.ccniit.graduation.dao.mysql;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.qo.VoterQuery;

public class VoterDaoTest extends BaseTest {

	@Resource
	VoterDao voterDao;

	@Test
	public void testInsertVoter() {
		Voter voter = new Voter(1, "1174310485@qq.com", "13551174063", "Widmore");
		voterDao.insertVoter(voter);
		Assert.assertNotEquals(0, voter.getId());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteVoter() {
		int resilt = voterDao.deleteVoter(3);
		Assert.assertEquals(1, resilt);
	}

	@Test
	@Transactional
	// @Rollback(true)
	public void testUpdateVoter() {
		Voter voter = new Voter(1, "1174310485@google.com", "18851174063", "Good");
		voter.setId(4);
		voterDao.updateVoter(voter);
	}

	@Test
	public void testSelectVoterFromVoterGroup() {
		VoterQuery voterQuery = new VoterQuery(1, 0);
		List<Voter> voters = voterDao.selectVoterFromVoterGroup(voterQuery);

		Assert.assertEquals(6, voters.size());
	}

}
