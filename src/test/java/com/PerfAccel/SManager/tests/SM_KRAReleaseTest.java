package com.PerfAccel.SManager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class SM_KRAReleaseTest  extends BaseClass{
	
	@Test
	public void KRAFlowValidationTest() throws InterruptedException
	{
		sm_loginpage.SM_LoginIntoFrontPage();
		sm_krareleasepage.SM_KRAFlowValidation();
		
	}

}
