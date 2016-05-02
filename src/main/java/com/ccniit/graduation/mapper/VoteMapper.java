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
	@Insert("INSERT INTO vote(tableName,category,author,title)VALUES(#{tableName},#{category},#{author},#{title})")
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
	 * 更新Vote到发布状态，需要更新预计结束时间、授权没类型、进度、URL
	 * 
	 * @param redictDate
	 *            预计结束时间
	 * @param auth
	 *            授权方式
	 * @param progress
	 *            进度
	 * @param url
	 *            生成的段URL
	 * @param id
	 *            vote的id
	 * @return 更新的条数(1=success)
	 */
	@Update("UPDATE vote SET predictDate=#{predictDate},auth=#{auth},progress=#{progress},url=#{url} WHERE id=#{id}")
	Integer updateVoteToPublish(@Param("predictDate") Date predictDate, @Param("auth") String auth,
			@Param("progress") int progress, @Param("url") String url, @Param("id") long id);

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
	 * 按照id查询Vote
	 * 
	 * @param Vote.id
	 * @return Vote {@link com.ccniit.graduation.pojo.db.Vote}
	 */
	@Select("SELECT id,url,tableName,category,title,progress,auth,inDate,predictDate,endDate,cover FROM vote WHERE id=#{vote} and removed=0;")
	Vote selectVoteById(long vote);

	/**
	 * 查询Vote的tableName
	 * 
	 * @param vote(Long)
	 * @return Vote.tableName
	 */
	@Select("SELECT tableName FROM vote WHERE id=#{vote}")
	String selectVoteTableName(long vote);

	/**
	 * 按照tableName查询Vote.id
	 * 
	 * @param Vote.tableName
	 * @return Vote.id
	 */
	@Select("SELECT id FROM vote WHERE tableName=#{tableName}")
	Long selectVoteIdByTableName(String tableName);

	/**
	 * 按照url查询Vote.id
	 * 
	 * @param url
	 *            sortURL
	 * @return Vote.ur
	 */
	@Select("SELECT id FROM vote WHERE url=#{url}")
	Long selectVoteIdByUrl(String url);

	/**
	 * 按照author和Vote.category查询多个Vote的id。采用倒叙
	 * 
	 * @param VoteQueryByCategory(offset,pageSize,author,category)
	 * @return List<Long>
	 */
	@Select("SELECT id FROM vote WHERE author=#{author} AND category=#{category} AND removed=0 ORDER BY id DESC LIMIT #{offset},#{pageSize}")
	List<Long> selectAuthorVotesId(PagedQuery query);

	// TODO
	List<VoteSearchResult> select();

}
