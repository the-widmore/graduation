package com.ccniit.graduation.dao.mongodb;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.doc.PrivateVoteData;
import com.ccniit.graduation.util.IPUtils;

public class VoteDataDaoTest extends BaseTest {

	private static final String TEST_COLLECTION = "_504213a4ae834bd0bb461418f3d8c62f";

	@Resource
	VoteDataDao voteDataDao;

	@Test
	public void testInsertVoteData() {
		PrivateVoteData dataDoc = new PrivateVoteData("chenyiyuan00@gmail.com", IPUtils.ipToLong("127.0.0.1"));

		voteDataDao.insertVoteData(TEST_COLLECTION, dataDoc);
	}

	@Test
	public void testDropVoteData() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectVote() {
		voteDataDao.selectVote(TEST_COLLECTION);
	}

}
