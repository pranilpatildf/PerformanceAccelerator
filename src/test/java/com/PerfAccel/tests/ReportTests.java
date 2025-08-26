package com.PerfAccel.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class ReportTests extends BaseClass{

	@Test
	public void FunctionAndRoleDropdownTest() throws InterruptedException
	{
		
	   loginpage.LoginIntoFrontPage();
	   reportpage.FunctionAndRoleDropdown();
	}
	
	
}
