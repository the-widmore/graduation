package com.ccniit.graduation.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.convertor.VoteToVoteVo;
import com.ccniit.graduation.dao.mysql.VoteDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.ServerException;
import com.ccniit.graduation.exception.VoteNotExistException;
import com.ccniit.graduation.pojo.db.Vote;
import com.ccniit.graduation.pojo.db.Vote.VoteCategory;
import com.ccniit.graduation.pojo.db.VoteContent;
import com.ccniit.graduation.pojo.qo.PagedQuery;
import com.ccniit.graduation.pojo.qo.VoteCreater;
import com.ccniit.graduation.pojo.qo.VotePublishVo;
import com.ccniit.graduation.pojo.vo.VoteVo;
import com.ccniit.graduation.resource.CacheNames;
import com.ccniit.graduation.resource.VoteResource;
import com.ccniit.graduation.service.AuthCodeService;
import com.ccniit.graduation.service.AuthorContentCountService;
import com.ccniit.graduation.service.PermissionService;
import com.ccniit.graduation.service.PermissionService.ResourceType;
import com.ccniit.graduation.service.VoteContentService;
import com.ccniit.graduation.service.VoteService;
import com.ccniit.graduation.service.VoteTagService;
import com.ccniit.graduation.service.VoteVoterGroupService;
import com.ccniit.graduation.util.DateUtils;
import com.ccniit.graduation.util.LoggerUtils;
import com.ccniit.graduation.util.StringUtils;

@Service("voteService")
public class VoteServiceImpl implements VoteService {

	private static final Logger ERR = LoggerUtils.getErr();

	@Resource
	private VoteDao voteDao;
	@Resource
	private VoteTagService voteTagService;
	@Resource
	private VoteToVoteVo voteToVoteVo;
	@Resource
	private VoteContentService voteContentService;
	@Resource
	private PermissionService permissionService;
	@Resource
	private VoteVoterGroupService voterGroupService;
	@Resource
	private AuthCodeService authCodeService;
	@Resource
	private AuthorContentCountService authorCountService;

	@Override
	public Long createVote(Vote vote) {
		voteDao.insertVote(vote);
		Long voteId = vote.getId();
		// 添加空内容
		voteContentService.createVoteContent(new VoteContent(voteId));
		// 更新计数器
		authorCountService.updateAuthorContentCounter(vote.getAuthor());
		return voteId;
	}

	@CacheEvict(cacheNames = CacheNames.AUTHOR_VOTE_COUNT, key = "#author")
	@Override
	public Long createVote(VoteCreater creater) throws IException {
		Vote vote = new Vote();

		// from create
		vote.setAuthor(creater.getAuthor());
		vote.setTitle(creater.getTitle());

		// random and unique value
		vote.setTableName(StringUtils._getUUID());
		vote.setCategory(VoteCategory.vote.toString());

		// other default value(inDate,progress,auth)

		// 保存数据库
		Long voteId = createVote(vote);
		if (0 == voteId) {
			throw new ServerException("insert vote error");
		}

		String tags = creater.getTags();
		if (org.apache.commons.lang.StringUtils.isNotBlank(tags)) {
			voteTagService.insertTagToVote(voteId, tags);
		}

		return voteId;
	}

	@Cacheable(cacheNames = CacheNames.VOTE, key = "#voteId")
	@Override
	public Vote selectVote(long voteId) throws IException {
		Vote vote = voteDao.selectVoteById(voteId);
		if (null == vote) {
			throw new VoteNotExistException(String.format("没有找到id为%s的Vote", voteId));
		}
		return vote;
	}

	@Override
	public Vote selectVote(VoteSelectCondition condition, String param) throws IException {
		Long voteId = 0L;
		switch (condition) {
		case tableName:
			voteId = voteDao.selectVoteIdByTableName(param);
			break;
		case url:
			voteId = voteDao.selectVoteIdByUrl(param);
			break;
		default:
			break;
		}
		if (null == voteId) {
			throw new VoteNotExistException("无法找到该vote");
		}

		return selectVote(voteId);
	}

	@Cacheable(cacheNames = CacheNames.VOTE_VO, key = "#voteId")
	@Override
	public VoteVo selectVoteVo(long voteId) throws IException {
		Vote vote = selectVote(voteId);
		VoteVo voteVo = voteToVoteVo.convert(vote);
		return voteVo;
	}

	@Override
	public Integer updateVoteByPublish(VotePublishVo publishVo, Long author) throws IException {

		Long vote = publishVo.getVoteId();
		permissionService.havePermission(ResourceType.vote, author, vote);

		String authType = publishVo.getAuthType();
		Date predictDate = DateUtils.parseDate(publishVo.getEndDate());
		String url = StringUtils.getRandomString(4);

		try {
			voteDao.updateVoteToPublish(predictDate, publishVo.getAuthType(), VoteResource.PUBLISHED, url, vote);
		} catch (Exception e) {
			ERR.error("发布Vote失败", e);
		}

		// 预计结束时间、授权没类型、进度、URL

		// 根据不同的授权方式来处理
		if (Vote.AuthType.PROTECTED.toString().equals(authType)) {
			authCodeService.generateVoteAuthCode(vote);
		}

		if (Vote.AuthType.PRIVATE.toString().equals(authType)) {
			List<Long> voteGroups = publishVo.getVoteGroup();
			for (Long voteGroup : voteGroups) {
				permissionService.havePermission(ResourceType.voterGroup, author, voteGroup);
			}

			Integer inserted = voterGroupService.insertVoterGroups(vote, voteGroups.toArray(new Long[] {}));
			if (inserted == voteGroups.size()) {
				return 1;
			}

			// 添加voter到邮件队列 TODO
		}

		return 0;
	}

	@Override
	public Long selectVoteIdByURL(String url) {
		return voteDao.selectVoteIdByUrl(url);
	}

	@Override
	public List<VoteVo> selectVoteVos(PagedQuery query) throws IException {
		List<Long> voteIds = voteDao.selectAuthorVotesId(query);
		List<VoteVo> voteVos = new ArrayList<>(voteIds.size());
		for (Long voteId : voteIds) {
			VoteVo vo = selectVoteVo(voteId);
			voteVos.add(vo);
		}
		return voteVos;
	}

	@Override
	public Integer deleteVote(Long vote, Long author) throws IException {
		permissionService.havePermission(ResourceType.vote, author, vote);

		// TODO
		// 更新计数器
		authorCountService.updateAuthorContentCounter(author);
		return null;
	}

}
