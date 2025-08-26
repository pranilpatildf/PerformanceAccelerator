package com.PerfAccel.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class RolesTests extends BaseClass {

	@Test
	public void AddNewRoleTest() throws InterruptedException
	{
		loginpage.LoginIntoFrontPage();
		rolespage.AddNewRole();
	}
	
}
