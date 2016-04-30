package com.ccniit.graduation.builder;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

/**
 * 资源缓存Key生成器
 */
@Component("permissionCacheKeyGenerator")
public class PermissionCacheKeyGenerator implements KeyGenerator {

	@Override
	public Object generate(Object target, Method method, Object... params) {
		return Arrays.toString(params).hashCode();
	}

}
