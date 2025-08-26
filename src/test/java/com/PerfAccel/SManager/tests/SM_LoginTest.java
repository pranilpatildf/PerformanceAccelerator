package com.PerfAccel.SManager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class SM_LoginTest extends BaseClass{

	@Test
	public void Login () throws InterruptedException
	
	{
		sm_loginpage.SM_LoginIntoFrontPage();
		
	}
	
}
