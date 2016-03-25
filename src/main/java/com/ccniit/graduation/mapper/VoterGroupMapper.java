package com.ccniit.graduation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ccniit.graduation.pojo.db.VoterGroup;

public interface VoterGroupMapper {

	/**
	 * 插入一个联系人组
	 * 
	 * @param VoterGroup
	 * @return VoterGroup.id
	 */
	@Insert("INSERT INTO voter_group(author,description,inDate) VALUES(#{author},#{description},NOW());")
	@SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = {
			"SELECT LAST_INSERT_ID() AS id" })
	Long insertVoterGroup(VoterGroup voterGroup);

	/**
	 * 获取一个Author的所有VoterGroup
	 * 
	 * @param authorId
	 * @return List<VotreGroup> @see VoterGroup
	 */
	@Select("SELECT id,author,quantity,description,inDate FROM voter_group WHERE author=#{authorId}")
	List<VoterGroup> selectVoterGroups(long authorId);

	/**
	 * 根据VoterGroupId，获取一个VoterGroup
	 * 
	 * @param VoterGroupId
	 * @return VoterGroup
	 */
	@Select("SELECT id,author,quantity,description,inDate FROM voter_group WHERE id=#{voterGroupId}")
	VoterGroup selectVoterGroup(long voterGroupId);

	/**
	 * 删除一个VoterGroup，按照VoterGroupId
	 * 
	 * @param voterGroupId
	 * @return deleted record
	 */
	@Delete("DELETE FROM voter_group WHERE id=#{voterGroupId}")
	Integer deleteVoterGroup(long voterGroupId);

	/**
	 * 更新VoterGroup.quantity(人数)；
	 * 
	 * @param VoterGroup.id
	 * @return updated recode
	 */
	@Update("UPDATE voter_group SET quantity=(SELECT COUNT(id) FROM voter WHERE voterGroup=#{voterGroupId}) WHERE id=#{voterGroupId}")
	Integer updateVoterGroupQuantity(long voterGroupId);

}
