package com.ccniit.graduation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ccniit.graduation.pojo.qo.VoteQueryByTag;
import com.ccniit.graduation.pojo.qo.VoteQueryByTitle;

public interface VoteSearchMapper {

	@Select("SELECT DISTINCT vote.id FROM vote WHERE title LIKE CONCAT('%',#{title},'%') AND removed=0 ORDER BY id DESC LIMIT #{offset},#{pageSize};")
	List<Long> selectVoteByTitle(VoteQueryByTitle VoteQueryByTitle);

	@Select("SELECT DISTINCT vote FROM vote_tag INNER JOIN tag ON tag.id=vote_tag.tag WHERE tag.tag LIKE CONCAT('%',#{tag},'%') ORDER BY vote_tag.id LIMIT #{offset},#{pageSize};")
	List<Long> selectVoteByTag(VoteQueryByTag VoteQueryByTag);

}
