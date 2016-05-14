/**
* 
 */
package com.ccniit.graduation.service;

import com.ccniit.graduation.pojo.common.PageInfo;
import com.ccniit.graduation.pojo.db.Vote.VoteCategory;

/**
 * @Title: PageService.java
 * @Description: 获取分页信息（当前页数和总共的页数）
 * @author chen.zhijun
 * @date 2016年5月13日 下午2:11:16
 * @version V1.0
 */
public interface PageInfoService {

	PageInfo getVotePage(Long author, VoteCategory category);

	PageInfo getVoterPage(Long voterGroup);

}
