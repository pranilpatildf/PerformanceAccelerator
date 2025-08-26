package com.PerfAccel.Manager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class M_LoginLogoutTest extends BaseClass {

	
	@Test
	public void M_LogoutTest() throws InterruptedException {
		
		
		m_loginpage.M_LoginIntoFrontPage();
		m_loginlogoutpage.M_LogoutPage();
		
		
	}
}
