package com.ccniit.graduation.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.NotFoundSessionException;
import com.ccniit.graduation.resource.Commons;

public class ShiroUtils {

	private static final Logger LOG = LoggerFactory.getLogger(ShiroUtils.class);

	private ShiroUtils() {

	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	public static Session createSession() {
		return getSubject().getSession(true);
	}

	public static Session getSession() {
		return getSubject().getSession();
	}

	public static void addAttribute(Object key, Object value) {
		Session session = getSession();
		// if session not exist create
		if (null == session) {
			session = createSession();
		}

		session.setAttribute(key, value);
	}

	public static Object getSessionValue(Object sessionKey) throws IException {
		Session session = getSession();

		if (null == session) {
			throw new NotFoundSessionException("没有找到该Session");
		}

		return session.getAttribute(sessionKey);
	}

	public static long getUserId() throws IException {
		Object object = getSessionValue(Commons.SESSION_KEY_AUTHOR_ID);

		if (null == object) {
			return 0L;
		}

		if (object instanceof Long) {
			return (Long) object;
		} else {
			LOG.error("Session typs:{} value:{}", object.getClass().getName(), object);
			return -1L;
		}

	}

}
