package com.PerfAccel.tests;


import org.testng.annotations.Test;

import base.BaseClass;

public class SettingTests extends BaseClass{
	
	
	@Test(priority=1)
	public void SettingRolesTest() throws InterruptedException
	{   
		loginpage.LoginIntoFrontPage();
		settingpage.SelectDropdownRoles();
	}
    
	@Test(priority=2)
	public void EnterSettingTest() throws InterruptedException
	{  
		loginpage.LoginIntoFrontPage();
		settingpage.EnterSettingPage();
		
	}
	
	
	
	
}
