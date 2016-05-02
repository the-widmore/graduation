package com.ccniit.graduation.dao.mysql;

import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.pojo.qo.VoteQueryByTag;
import com.ccniit.graduation.pojo.qo.VoteQueryByTitle;

public class VoteSearchDaoTest extends BaseTest {

	@Resource
	VoteSearchDao voteSearchDao;

	@Test
	public void testSelectVoteByTitle() {
		VoteQueryByTitle voteQueryByTitle = new VoteQueryByTitle(0, 20);
		voteQueryByTitle.setTitle("t");

		System.out.println(Arrays.toString(voteSearchDao.selectVoteByTitle(voteQueryByTitle).toArray()));
	}

	@Test
	public void testSelectVoteByTag() {
		VoteQueryByTag voteQueryByTag = new VoteQueryByTag(0, 20);
		voteQueryByTag.setTag("Tag");
		System.out.println(Arrays.toString(voteSearchDao.selectVoteByTag(voteQueryByTag).toArray()));
	}

}
