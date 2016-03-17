package com.ccniit.graduation.plus.poi;

import java.util.List;

import com.ccniit.graduation.pojo.db.Voter;

public interface VoterParse<T> {

	List<Voter> parse(T t);

}
