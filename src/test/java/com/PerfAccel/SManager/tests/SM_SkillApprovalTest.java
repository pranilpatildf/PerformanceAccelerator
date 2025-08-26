package com.PerfAccel.SManager.tests;

import org.testng.annotations.Test;



import base.BaseClass;

public class SM_SkillApprovalTest  extends BaseClass{
	
	@Test
	public void SMSkillApprovalTest() throws InterruptedException
	{
		sm_loginpage.SM_LoginIntoFrontPage();
	    sm_skillapprovalpage.SM_SkillApprovalTabValidation();
		
		
	}

}
