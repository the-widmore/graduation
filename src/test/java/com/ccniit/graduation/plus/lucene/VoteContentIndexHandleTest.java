package com.ccniit.graduation.plus.lucene;

import javax.annotation.Resource;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.TopDocs;
import org.junit.Assert;
import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.dao.mysql.VoteContentDao;
import com.ccniit.graduation.pojo.db.VoteContent;

public class VoteContentIndexHandleTest extends BaseTest {

	@Resource
	VoteContentIndexHandle voteContentIndexHandle;
	@Resource
	VoteContentDao voteContentDao;

	@Test
	public void testAddVoteContentToIndex() {
		for (VoteContent voteContent : voteContentDao.selectAll()) {
			voteContentIndexHandle.addVoteContentToIndex(voteContent);
		}
	}

	@Test
	public void testSearchVoteContentFromIndex() {
		TopDocs topDocs = voteContentIndexHandle.searchVoteContentFromIndex("p");
		System.out.println("totalHits:" + topDocs.totalHits);
	}

	@Test
	public void testSearchVoteContentById() {
		Document document = voteContentIndexHandle.searchVoteContentById(47L);
		Long originalId = document.getField(VoteContentIndexHandle.VOTE_ID_FIELD).numericValue().longValue();
		Assert.assertEquals(originalId, new Long(47));
	}

}
