package com.ccniit.graduation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ccniit.graduation.pojo.db.VoterGroup;

public interface VoterGroupMapper {

	@Insert("INSERT INTO voter_group(author,description,inDate) VALUES(#{author},#{description},NOW());")
	@SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = {
			"SELECT LAST_INSERT_ID() AS id" })
	long insertVoterGroup(VoterGroup voterGroup);

	@Select("SELECT id,author,quantity,description,inDate FROM voter_group WHERE author=#{authorId}")
	List<VoterGroup> selectVoterGroups(long authorId);

	@Select("SELECT id,author,quantity,description,inDate FROM voter_group WHERE id=#{voterGroupId}")
	VoterGroup selectVoterGroup(long voterGroupId);

	@Delete("DELETE FROM voter_group WHERE id=#{voterGroupId}")
	int deleteVoterGroup(long voterGroupId);

	@Update("UPDATE voter_group SET quantity=(SELECT COUNT(id) FROM voter WHERE voterGroup=#{voterGroupId}) WHERE id=#{voterGroupId}")
	int updateVoterGroupQuantity(long voterGroupId);

}
