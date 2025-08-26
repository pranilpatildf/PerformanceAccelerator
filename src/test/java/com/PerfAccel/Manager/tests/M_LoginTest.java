package com.PerfAccel.Manager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class M_LoginTest extends BaseClass{

	@Test
	public void Login () throws InterruptedException
	
	{
		m_loginpage.M_LoginIntoFrontPage();
		
	}
	
}
