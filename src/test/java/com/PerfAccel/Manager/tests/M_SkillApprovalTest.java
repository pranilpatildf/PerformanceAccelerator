package com.PerfAccel.Manager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class M_SkillApprovalTest  extends BaseClass{
	
	@Test
	public void SkillApprovalTest() throws InterruptedException
	{
		m_loginpage.M_LoginIntoFrontPage();
		m_skillaprrovalpage.SkillApprovalTabValidation();
		
		
	}

}
