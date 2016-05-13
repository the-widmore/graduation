package com.ccniit.graduation.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.pojo.qo.VoterQuery;

public interface VoterMapper {

	@Insert("INSERT INTO voter(voterGroup,email,phone,alias) VALUES(#{voterGroup},#{email},#{phone},#{alias});")
	@SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = {
			"SELECT LAST_INSERT_ID() AS id;" })
	Long insertVoter(Voter voter);

	@Delete("DELETE FROM voter WHERE id=#{voterId};")
	Integer deleteVoter(long voterId);

	@Update("UPDATE voter SET email=#{email},phone=#{phone},alias=#{alias} WHERE id=#{id};")
	Integer updateVoter(Voter voter);

	@Update("UPDATE voter SET email=#{email} WHERE id=#{id};")
	Integer updateVoterEmail(@Param("id") long id, @Param("email") String email);

	@Update("UPDATE voter SET phone=#{phone} WHERE id=#{id};")
	Integer updateVoterPhone(@Param("id") long id, @Param("phone") String phone);

	@Update("UPDATE voter SET alias=#{alias} WHERE id=#{id};")
	Integer updateVoterAlias(@Param("id") long id, @Param("alias") String alias);

	@Select("SELECT id,email,phone,alias FROM voter WHERE voterGroup=#{voterGroup} LIMIT #{offset},#{pageSize};")
	List<Voter> selectVoterFromVoterGroup(VoterQuery voterQuery);

	@Select("SELECT id,email,phone,alias FROM voter WHERE id=#{voterId};")
	Voter selectVoteById(long voterId);

	/**
	 * 对一个Vote的Voter的email查询并去重
	 */
	@Select("SELECT DISTINCT email from voter WHERE voterGroup in(SELECT vote_voter_group.voterGroup FROM vote_voter_group WHERE vote=#{vote});")
	Set<String> selectAllVoterEmailByVote(Long vote);

}
