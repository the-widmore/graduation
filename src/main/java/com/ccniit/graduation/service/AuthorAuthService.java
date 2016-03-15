package com.ccniit.graduation.service;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.vo.EmailToken;

public interface AuthorAuthService {

	boolean verifyByEmail(EmailToken token) throws IException;

}
