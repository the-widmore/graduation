package com.ccniit.graduation.plus.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.pojo.vo.EmailToken;
import com.ccniit.graduation.service.AuthorAuthService;
import com.ccniit.graduation.util.LoggerUtils;

@Component("myRealm")
public class MyRealm extends AuthorizingRealm {

	private static final Logger LOG_AUTH = LoggerUtils.getAuth();

	@Resource
	private AuthorAuthService authorAuthService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

		String username = usernamePasswordToken.getUsername();
		char[] password = usernamePasswordToken.getPassword();
		LOG_AUTH.info("Username:{} try login", username);

		try {
			if (authorAuthService.verifyByEmail(new EmailToken(username, new String(password)))) {
				return new SimpleAuthenticationInfo(username, password, getName());
			}
		} catch (IException e) {
			e.printStackTrace();
		}

		String host = usernamePasswordToken.getHost();
		LOG_AUTH.debug("host:{}", host);

		return null;
	}

}
