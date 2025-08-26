package com.PerfAccel.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class LoginLogoutTest extends BaseClass {

	
	@Test
	public void LogoutTest() throws InterruptedException {
		
		loginpage.LoginIntoFrontPage();
		logout.LogoutPage();
	}
}
