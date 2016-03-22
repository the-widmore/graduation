package com.ccniit.graduation.plus.shiro;

public interface Permission {

	boolean havePermission(long authorId, long resource);

}
