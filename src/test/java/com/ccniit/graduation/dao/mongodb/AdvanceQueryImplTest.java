package com.ccniit.graduation.dao.mongodb;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.doc.BaseVoteData;
import com.ccniit.graduation.util.JSONUtils;

public class AdvanceQueryImplTest extends BaseTest {

	@Resource
	IAdvanceQuery advanceQuery;

	@Test
	public void testFindAllByField() {
		List<BaseVoteData> dbObjects = advanceQuery.findAllByField(VoteDataDaoTest.TEST_COLLECTION, "data");
		for (BaseVoteData dbObject : dbObjects) {
			testLog.debug(JSONUtils.toJSON(dbObject));
		}
	}

}
