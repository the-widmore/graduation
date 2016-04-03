package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.service.PermissionService;
import com.ccniit.graduation.service.PermissionService.ResourceType;

public class PermissionServiceImplTest extends BaseTest {

	@Resource
	PermissionService permissionService;

	@Test
	public void testHavePermission() {
		for (int i = 0; i < 5; i++) {
			System.out.println(permissionService.havePermission(ResourceType.vote, 1, 1));
			System.out.println(permissionService.havePermission(ResourceType.voter, 1, 1));
			System.out.println(permissionService.havePermission(ResourceType.voterGroup, 1, 1));
		}
	}

}
