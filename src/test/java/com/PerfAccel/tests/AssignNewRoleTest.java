package com.PerfAccel.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class AssignNewRoleTest extends BaseClass  {
	
	
	@Test
	public void AssignRoleTest() throws InterruptedException
	{
		loginpage.LoginIntoFrontPage();
		assignnewrolepage.AssignRole();
		
	}

}
