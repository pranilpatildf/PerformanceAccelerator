package com.PerfAccel.SManager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class SM_KRAsApprovalTest extends BaseClass{
     
	@Test
	public void KRAQuarterDropdownTest() throws InterruptedException
	{
		sm_loginpage.SM_LoginIntoFrontPage();
		sm_kraapprovalpage.KRAQuarterDropdown();
		
	}
	
	
}
