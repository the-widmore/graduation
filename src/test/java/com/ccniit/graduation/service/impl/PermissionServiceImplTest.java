package com.ccniit.graduation.service.impl;

import javax.annotation.Resource;

import org.junit.Test;

import com.ccniit.graduation.BaseTest;
import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.service.PermissionService;
import com.ccniit.graduation.service.PermissionService.ResourceType;

public class PermissionServiceImplTest extends BaseTest {

	@Resource
	PermissionService permissionService;

	@Test
	public void testHavePermission() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(permissionService.havePermission(ResourceType.vote, 1L, 11L));
				System.out.println(permissionService.havePermission(ResourceType.voter, 1L, 1L));
				System.out.println(permissionService.havePermission(ResourceType.voterGroup, 1L, 1L));
			} catch (IException e) {
				// TODO Auto-generated catch block
			}
		}
	}

}
