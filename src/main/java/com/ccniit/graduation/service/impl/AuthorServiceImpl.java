package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ccniit.graduation.builder.AuthorContentCounterBuilder;
import com.ccniit.graduation.convertor.AuthorBaseUpdaterToAuthor;
import com.ccniit.graduation.dao.mysql.AuthorDao;
import com.ccniit.graduation.dao.mysql.AuthorInfoDao;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.db.Author;
import com.ccniit.graduation.pojo.qo.AuthorBaseUpdater;
import com.ccniit.graduation.pojo.qo.AuthorInfoUpdater;
import com.ccniit.graduation.pojo.vo.AuthorContentCounter;
import com.ccniit.graduation.pojo.vo.EmailToken;
import com.ccniit.graduation.resource.CacheNams;
import com.ccniit.graduation.service.AuthorAuthService;
import com.ccniit.graduation.service.AuthorService;
import com.ccniit.graduation.util.LoggerUtils;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	private static final Logger DEV = LoggerUtils.getDev();
	private static final Logger BUS = LoggerUtils.getBus();

	@Resource
	AuthorContentCounterBuilder authorContentCounterBuilder;
	@Resource
	AuthorDao authorDao;
	@Resource
	AuthorInfoDao authorInfoDao;
	@Resource
	AuthorAuthService authorAuthService;
	@Resource
	AuthorBaseUpdaterToAuthor authorBaseUpdaterToAuthor;

	@Override
	public long register(Author author) {
		authorDao.insertAuthor(author);
		long authorId = author.getId();
		authorInfoDao.insertEmptyAuthorInfo(authorId);

		BUS.info("账户注册{}", author);

		return authorId;
	}

	@Override
	public int updateAuthorBase(AuthorBaseUpdater updater) throws IException {
		// TODO AuthorUpdater to Author

		EmailToken userToken = new EmailToken(updater.getEmail(), updater.getOldPassword());
		boolean isMatched = authorAuthService.verifyByEmail(userToken);

		DEV.debug("passwordIsMatched{}", isMatched);

		// 密码匹配
		if (isMatched) {
			// 更新出去密码以外的字段
			Author author = authorBaseUpdaterToAuthor.convert(updater);
			int result = authorDao.updateAuthorWithoutPassword(author);

			String newPassword = updater.getNewPassword();
			if (StringUtils.isNotBlank(newPassword) && newPassword.equals(updater.getConfirmPassword())) {
				return authorDao.updateAuthorPassword(author);
			} else if (StringUtils.isNotBlank(newPassword) && !newPassword.equals(updater.getConfirmPassword())) {
				return AuthorServiceImpl.PASSWORD_NOT_SAME;
			}

			String secondPassword = updater.getSecondPassword();
			if (StringUtils.isNotBlank(secondPassword)) {
				return authorDao.updateAuthorSecondPassword(author);
			}

			return result;
		} else {
			return AuthorService.PASSWORD_ERROR;
		}

	}

	@Override
	public int updateAuthorInfo(AuthorInfoUpdater authorUpdater) {
		return authorInfoDao.updateAuthorInfo(authorUpdater);
	}

	@Override
	public long getAuthorIdByEmail(String email) {
		return authorDao.selectAuthorIdByEmail(email);
	}

	@Override
	public boolean authorIsExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Cacheable(cacheNames = CacheNams.AUTHOR, key = "#authorId")
	@Override
	public Author findAuthorById(long authorId) {
		return authorDao.selectById(authorId);
	}

	@Cacheable(cacheNames = CacheNams.AUTHOR_VOTE_COUNT, key = "#authorId")
	@Override
	public AuthorContentCounter getAuthorContentCounter(long authorId) {
		return authorContentCounterBuilder.build(authorId);
	}

}
