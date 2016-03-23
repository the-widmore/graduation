package com.ccniit.graduation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ccniit.graduation.pojo.db.VoteTag;
import com.ccniit.graduation.pojo.qo.VoteQuery;
import com.ccniit.graduation.pojo.vo.VoteVo;

public interface VoteTagMapper {

	/**
	 * 插入投票的标签(按照tag的id)
	 * 
	 * @param voteId
	 * @param tagId
	 * @return success inserted recode
	 */
	@Insert("INSERT INTO vote_tag(vote,tag) VALUES(#{vote},#{tagId})")
	Integer insertVoteTagByTagId(@Param("vote") long vote, @Param("tagId") int tagId);

	/**
	 * 按照tag模糊查询VoteTag hot最高的10个
	 * 
	 * @param tag
	 * @return List<VoteTag>(size=10)
	 */
	// TODO SQL inject
	@Select("SELECT id,tag FROM tag WHERE tag LIKE CONCAT('%',#{tag},'%') ORDER BY hot DESC LIMIT 0,10")
	List<VoteTag> selectTop10Tags(String tag);

	/**
	 * 查询tag的id,不存在返回null
	 * 
	 * @param tag
	 * @return tag.id(if not exist return null)
	 */
	// TODO add tag index
	@Select("SELECT id FROM tag WHERE tag=#{tag}")
	Integer selectTagId(String tag);

	/**
	 * 插入投票的标签，按照tag(String类型，必须保证已经存在)
	 * 
	 * @param vote.id
	 * @param tag
	 * @return 成功插入的条数
	 */
	@Insert("INSERT INTO vote_tag(vote,tag) VALUES(#{vote},(SELECT id FROM tag WHERE tag=#{tag}))")
	Integer insertVoteTagByTagStr(@Param("vote") long vote, @Param("tag") String tag);

	/**
	 * 查询一个Vote的tags
	 * 
	 * @param vote.id
	 * @return tags
	 */
	@Select("SELECT GROUP_CONCAT(distinct tag.tag separator ' ') FROM vote_tag INNER JOIN tag ON tag.id=vote_tag.tag WHERE vote=#{vote}")
	String selectVoteTags(long vote);

	/**
	 * 按照tag,搜索Vote。
	 *
	 * @param VoteQuery
	 * @return List<VoteVo>
	 */
	// TODO 分页
	@Select("")
	List<VoteVo> selectVotes(VoteQuery query);

}
