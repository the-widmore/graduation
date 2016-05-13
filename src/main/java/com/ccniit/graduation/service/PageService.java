/**
* 
 */
package com.ccniit.graduation.service;

import com.ccniit.graduation.pojo.common.Page;

/**
 * @Title: PageService.java
 * @Description: TODO
 * @author chen.zhijun
 * @date 2016年5月13日 下午2:11:16
 * @version V1.0
 */
public interface PageService {

	Page getVotePage(Long author);

	Page getVoterPage(Long voterGroup);

}
