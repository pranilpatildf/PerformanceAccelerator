package com.PerfAccel.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class KRATemplateTests extends BaseClass {
	
	@Test(enabled = false)
	public void KRATemplateDropdownTest() throws InterruptedException
	{
		loginpage.LoginIntoFrontPage();
		kratemplatepage.ValidateKRATemplatesDropdown();
	}

	
	@Test(enabled = false)
	public void CreateTemplateTest() throws InterruptedException
	{
		loginpage.LoginIntoFrontPage();
		kratemplatepage.CreateTemplate();
	}
	
	
	@Test(enabled = false)
	public void EditKRATemplateTest() throws InterruptedException
	{
		
		loginpage.LoginIntoFrontPage();
		kratemplatepage.EditKRATemplate();
	}
	
	@Test(enabled = false)
	public void DeleteKRATemplateTest() throws InterruptedException
	{
		loginpage.LoginIntoFrontPage();
		kratemplatepage.DeleteKRATemplate();
		
	}
	
	@Test
	public void ViewTemplate_And_AddRolesAndKRAsTest() throws InterruptedException
	{
		loginpage.LoginIntoFrontPage();
		kratemplatepage.ViewTemplate_And_AddRolesAndKRAs();
		
	}
	
}
