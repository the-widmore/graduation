package com.ccniit.graduation.dao.mongodb;

import java.util.List;

import com.ccniit.graduation.pojo.doc.BaseVoteData;

public interface IAdvanceQuery {

	List<BaseVoteData> findAllByField(String collectionName, String field);

}
