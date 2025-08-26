package com.PerfAccel.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class SkillsTests extends BaseClass{
	
	@Test(enabled = false)
	public void SkillSearchTest() throws InterruptedException
	{   loginpage.LoginIntoFrontPage();
		skillspage.SkillSearch();
		
	}

	@Test(enabled = false)
	public void SkillDropdownsTest() throws InterruptedException
	{   loginpage.LoginIntoFrontPage();
		skillspage.SkillDropdowns();
		
	}
	

	@Test(enabled = false)
	public void AddSkillCategoryTest() throws InterruptedException
	{   loginpage.LoginIntoFrontPage();
		skillspage.AddSkillCategory();
		
	}

	@Test(enabled = false)
	public void DeleteCategoryTest() throws InterruptedException
	{   loginpage.LoginIntoFrontPage();
		skillspage.DeleteCategory();
		
	}
	
	@Test
	public void AddNewSkillTest() throws InterruptedException
	{   loginpage.LoginIntoFrontPage();
		skillspage.AddNewSkill();
		
	}
	
	
	
	
}
