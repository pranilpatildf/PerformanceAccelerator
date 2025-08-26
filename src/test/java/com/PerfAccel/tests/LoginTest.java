package com.PerfAccel.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class LoginTest extends BaseClass{

	@Test
	public void Login () throws InterruptedException
	
	{
		loginpage.LoginIntoFrontPage();
	}
	
}
