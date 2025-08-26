package com.PerfAccel.tests;

import org.testng.annotations.Test;

import base.BaseClass;
public class KRATests extends BaseClass {

	 @Test(priority=1)
		public void ValidateKRADropdownsTest() throws InterruptedException
		{
			
			loginpage.LoginIntoFrontPage();
			krapage.ValidateKRADropdowns();
			
		}
		

    @Test(priority=2,enabled = false)
	public void AddNewKRATest() throws InterruptedException
	{
		
		loginpage.LoginIntoFrontPage();
		krapage.AddNewKRA();
		
	}
	
	@Test(priority = 3,enabled = false)
	public void AddAndUpdateKRATest() throws InterruptedException
	
	{  
		loginpage.LoginIntoFrontPage();
		krapage.AddAndEditKRA();
	}
	
	@Test(priority = 4)
	public void DeleteKRATest() throws InterruptedException
	
	{  
		loginpage.LoginIntoFrontPage();
		krapage.DeleteKRA();
		
	}
}
