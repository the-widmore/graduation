package com.ccniit.graduation.dao.mongodb;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.doc.PrivateVoteData;
import com.ccniit.graduation.util.IPUtils;

public class VoteDataDaoTest extends BaseTest {

	private static final String TEST_COLLECTION = "_0253c1be667b43298e98a3a200686a9a";

	@Resource
	VoteDataDao voteDataDao;

	@Test
	public void testInsertVoteData() {
		PrivateVoteData dataDoc = new PrivateVoteData("chen@gmail.com", IPUtils.ipToLong("127.0.0.1"));

		voteDataDao.insertVoteData(TEST_COLLECTION, dataDoc);
		fail("Not yet implemented");
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
