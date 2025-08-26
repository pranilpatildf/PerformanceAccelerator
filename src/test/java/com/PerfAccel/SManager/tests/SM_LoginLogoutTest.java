package com.PerfAccel.SManager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class SM_LoginLogoutTest extends BaseClass {

	
	@Test
	public void SM_LogoutTest() throws InterruptedException {
		
		
		sm_loginpage.SM_LoginIntoFrontPage();
		sm_loginlogout.SM_LogoutPage();
		
		
	}
}
