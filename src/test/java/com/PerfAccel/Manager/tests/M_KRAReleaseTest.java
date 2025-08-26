package com.PerfAccel.Manager.tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class M_KRAReleaseTest  extends BaseClass{
	
	@Test
	public void KRAFlowValidationTest() throws InterruptedException
	{
		m_loginpage.M_LoginIntoFrontPage();
		m_krarelease.KRAFlowValidation();
		
	}

}
