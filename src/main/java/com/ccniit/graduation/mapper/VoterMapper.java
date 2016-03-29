package com.ccniit.graduation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.qo.VoterQuery;

public interface VoterMapper {

	@Insert("INSERT INTO voter(voterGroup,email,phone,alias) VALUES(#{voterGroup},#{email},#{phone},#{alias})")
	@SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = {
			"SELECT LAST_INSERT_ID() AS id" })
	Long insertVoter(Voter voter);

	@Delete("DELETE FROM voter WHERE id=#{voterId}")
	Integer deleteVoter(long voterId);

	@Update("UPDATE voter SET email=#{email},phone=#{phone},alias=#{alias} WHERE id=#{id}")
	Integer updateVoter(Voter voter);

	@Update("UPDATE voter SET email=#{email} WHERE id=#{id}")
	Integer updateVoterEmail(long id);

	@Update("UPDATE voter SET phone=#{phone} WHERE id=#{id}")
	Integer updateVoterPhone(long id);

	@Update("UPDATE voter SET alias=#{alias} WHERE id=#{id}")
	Integer updateVoterAlias(long id);

	@Select("SELECT id,email,phone,alias FROM voter WHERE voterGroup=#{voterGroup} LIMIT #{offset},#{pageSize};")
	List<Voter> selectVoterFromVoterGroup(VoterQuery voterQuery);

	@Select("SELECT id,email,phone,alias FROM voter WHERE id=#{voterId}")
	Voter selectVoteById(long voterId);

}
