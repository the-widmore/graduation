package com.ccniit.graduation.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.qo.PagedQuery;
import com.ccniit.graduation.pojo.vo.VoteSearchResult;

public interface VoteMapper {

	/**
	 * 插入一条Vote记录
	 * 
	 * @param VoteResource
	 * @return Vote.id
	 */
	@Insert("INSERT INTO vote(tableName,category,author,title,predictDate)VALUES(#{tableName},#{category},#{author},#{title},#{predictDate})")
	@SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = {
			"SELECT LAST_INSERT_ID() AS id" })
	Long insertVote(Vote vote);

	/**
	 * 更新进度Vote.progress
	 * 
	 * @param Vpte.id
	 * @param Vote.progress
	 * @return successful updated recode
	 */
	@Update("UPDATE vote SET progress=#{progress} WHERE id=#{vote}")
	Integer updateVoteProgress(@Param("vote") long vote, @Param("progress") int progress);

	/**
	 * 
	 * 更新结束时间 Vote.endDate
	 * 
	 * @param Vote.id
	 * @param Vote.endDate
	 * @return successful updated recode
	 */
	@Update("UPDATE vote SET endDate=#{endDate} WHERE id=#{vote}")
	Integer updateVoteEndDate(@Param("vote") long vote, @Param("endDate") Date endDate);

	/**
	 * 查询Vote的tableName
	 * 
	 * @param vote(Long)
	 * @return Vote.tableName
	 */
	@Select("SELECT tableName FROM vote WHERE id=#{vote}")
	String selectVoteTableName(long vote);

	/**
	 * 按照id查询Vote
	 * 
	 * @param Vote.id
	 * @return Vote {@link com.ccniit.graduation.pojo.db.Vote}
	 */
	@Select("SELECT id,tableName,category,author,title,progress,inDate,predictDate,endDate FROM vote WHERE id=#{vote}")
	Vote selectVoteById(long vote);

	/**
	 * 按照tableName查询Vote
	 * 
	 * @param Vote.tableName
	 * @return Vote
	 */
	@Select("SELECT id,tableName,category,author,title,progress,inDate,predictDate,endDate FROM vote WHERE tableName=#{tableName}")
	Vote selectVoteByTableName(String tableName);

	/**
	 * 按照author和Vote.category查询多个Vote的id
	 * 
	 * @param VoteQueryByCategory(offset,pageSize,author,category)
	 * @return List<Long>
	 */
	@Select("SELECT id FROM vote WHERE author=#{author} AND category=#{category} LIMIT #{offset},#{pageSize}")
	List<Long> selectAuthorVotesId(PagedQuery query);

	// TODO
	List<VoteSearchResult> select();

}
